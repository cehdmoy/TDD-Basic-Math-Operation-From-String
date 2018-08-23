package expressionoperator.imp;

import expressionoperator.AuxInterfaceCommonOperation;
import expressionoperator.ExpressionOperator;
import mathoperator.MathOperator;

import static expressionoperator.IndexUtil.determinateFirstOperationIndex;
import static expressionoperator.IndexUtil.determinateIndex;


public class OperatorForSameOperationKindImp implements ExpressionOperator, AuxInterfaceCommonOperation {

    private String operationTypeOne;

    private String operationTypeTwo;

    private MathOperator mathOperator;


    public OperatorForSameOperationKindImp(String operationTypeOne, String operationTypeTwo, MathOperator mathOperator) {
        this.operationTypeOne = operationTypeOne;
        this.operationTypeTwo = operationTypeTwo;
        this.mathOperator = mathOperator;
    }

    public String reduceExpression(String expression) {


        int indexFirstPlusSym = determinateIndex(expression, operationTypeOne);

        int indexFirstSubtractionSym = determinateIndex(expression, operationTypeTwo);


        int fistOperationIndex = determinateFirstOperationIndex(indexFirstPlusSym, indexFirstSubtractionSym);

        String fistOperator = expression.substring(0, fistOperationIndex);

        String currentExpresion = expression.substring(fistOperationIndex + 1, expression.length());


        String operationKind = determinateOperation(fistOperationIndex, indexFirstSubtractionSym);


        return reduceExpression(fistOperator, currentExpresion, operationKind);

    }

    private String reduceExpression(String fistOperator, String currentExpression, String operationKind) {

        int indexFirstKindSym = determinateIndex(currentExpression, operationTypeOne);
        int indexSecondKindSym = determinateIndex(currentExpression, operationTypeTwo);
        int currentOperationSymIndex = determinateFirstOperationIndex(indexFirstKindSym, indexSecondKindSym);

        if (currentOperationSymIndex == -1) {
            return mathOperator.operateBySymbol(fistOperator, currentExpression, operationKind);

        }
        else if(currentOperationSymIndex == 0 && (operationKind.equals("+") ||operationKind.equals("-")))
        {
            return mathOperator.operateBySymbol(fistOperator, currentExpression, operationKind);
        }
        else {
            String currentOperationKind = determinateOperation(indexFirstKindSym, indexSecondKindSym);
            String secoendTerm = currentExpression.substring(0, currentOperationSymIndex);
            currentExpression = currentExpression.substring(currentOperationSymIndex + 1, currentExpression.length());
            String localResult = mathOperator.operateBySymbol(fistOperator, secoendTerm, operationKind);
            return reduceExpression(localResult, currentExpression, currentOperationKind);

        }
    }


    public  String determinateOperation(int indexMul, int indexDiv) {
        if ((indexDiv == -1 || indexMul < indexDiv) && indexMul > 0)
            return operationTypeOne;
        else
            return operationTypeTwo;
    }
}
