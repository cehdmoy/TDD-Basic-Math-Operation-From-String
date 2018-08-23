package expressionoperator.imp;

import expressionoperator.AuxInterfaceCommonOperation;
import expressionoperator.ExpressionOperator;

import static expressionoperator.IndexUtil.determinateFirstOperationIndex;
import static expressionoperator.IndexUtil.determinateIndex;
import static expressionoperator.SymbolUtil.isABasicOperationMathSymbol;

public class OperatorDiffKindOfSymolImp implements ExpressionOperator {

    private ExpressionOperator addKindOperator;

    private ExpressionOperator multKindOperator;

    public OperatorDiffKindOfSymolImp(ExpressionOperator addKindOperator, ExpressionOperator multKindOperator) {
        this.addKindOperator = addKindOperator;
        this.multKindOperator = multKindOperator;
    }

    @Override
    public String reduceExpression(String expression) {
        if (expression.isEmpty())
            return "Expression must not be empty";
        else if(isABasicOperationMathSymbol(expression))
        {
            if (isOnlyAddType(expression))
                return addKindOperator.reduceExpression(expression);
            else if (isOnlyMulType(expression))
                return multKindOperator.reduceExpression(expression);
            else {
                return reduce(expression);
            }
        }
        else {
            return expression;
        }
    }

    private boolean isOnlyMulType(String expression) {
        return !(expression.contains("+") || expression.contains("-"));
    }

    private boolean isOnlyAddType(String expression) {
        return !(expression.contains("*") || expression.contains("/"));
    }

    private String reduce(String expression)
    {


        int plusFirstIndex = determinateIndex(expression, "+");

        int subtractionFirstIndex = determinateIndex(expression, "-");

        int fistAddKindIndex = determinateFirstOperationIndex(plusFirstIndex, subtractionFirstIndex);


        int multFirstIndex =determinateIndex(expression, "*");

        int divFirstIndex =determinateIndex(expression, "/");


        int fistMulKindIndex = determinateFirstOperationIndex(multFirstIndex, divFirstIndex);


        if(fistAddKindIndex<=0&&fistMulKindIndex==-1 )
        {
            return expression;
        }
        else if (isOnlyAddType(expression))
            return addKindOperator.reduceExpression(expression);
        else if (isOnlyMulType(expression))
            return multKindOperator.reduceExpression(expression);
        else
        {
            if(fistMulKindIndex==fistAddKindIndex-1)
            {
                System.out.print("");
                return multKindOperator.reduceExpression(expression);
            }
            if (fistAddKindIndex > fistMulKindIndex) {
                String tempLeftSideExpresion = expression.substring(0, fistAddKindIndex);
                String currentExpression = expression.substring(fistAddKindIndex, expression.length());

                String multSideExpressionReduced = reduce(tempLeftSideExpresion);

                String operateCurrentExpression = reduce(multSideExpressionReduced + currentExpression);

                return reduce(operateCurrentExpression);


            } else {

                int previousAddKindIndex = findPreviousAddKindIndex(fistMulKindIndex, expression);

                String tempLeftSideExpresion = expression.substring(0, previousAddKindIndex + 1);



                String currentExpression = expression.substring(previousAddKindIndex + 1, expression.length());

                String multSideExpressionReduced = reduce(currentExpression);//;multKindOperator.reduceExpression(currentExpression);

                String operateCurrentExpression = reduce(tempLeftSideExpresion + multSideExpressionReduced);
                return reduce(operateCurrentExpression);
            }
        }
    }

    private int findPreviousAddKindIndex(int boundary, String expression)
    {
        int i=0;
        int previousIndex=-1;
        while (i<boundary)
        {
            char c = expression.charAt(i);
            if(String.valueOf(c).equals("+")||String.valueOf(c).equals("-"))
                previousIndex=i;

                i++;
        }
        return previousIndex;
    }


}
