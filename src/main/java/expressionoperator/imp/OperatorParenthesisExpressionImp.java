package expressionoperator.imp;

import expressionoperator.ExpressionOperator;

import static expressionoperator.IndexUtil.determinateIndex;
import static expressionoperator.SymbolUtil.doesExpresionHaveMathOpetationToResolve;
import static expressionoperator.SymbolUtil.isABasicOperationMathSymbol;

public class OperatorParenthesisExpressionImp implements ExpressionOperator {

    private ExpressionOperator expressionOperator;

    public OperatorParenthesisExpressionImp(ExpressionOperator expressionOperator) {
        this.expressionOperator = expressionOperator;
    }

    @Override
    public String reduceExpression(String expression) {
        String beginParentheses = "(";
        String endParentheses = ")";
        if (expression.equals("()")) {
            return "Cannot operate empty expression";
        } else {
            String firstExpressionToOperate = expression.replace(beginParentheses, "").replace(endParentheses, "");
            if (!firstExpressionToOperate.isEmpty()) {
                if (doesExpresionHaveMathOpetationToResolve(firstExpressionToOperate)) {
                        return handleParenthesesCase(expression);
                }
            }
            return firstExpressionToOperate;
        }
    }

    private String handleParenthesesCase(String expression) {

        int fistDigitInnerParenthesesBegin = determinateInnerIndexForLeftParentheses(expression,"(");


        int firstParenthesesEndIndex = determinateInnerIndexForRightParentheses(expression, ")",fistDigitInnerParenthesesBegin);



        String rightFromParentheses = expression.substring(firstParenthesesEndIndex + 1, expression.length());

        String leftFromParentheses = expression.substring(0, fistDigitInnerParenthesesBegin-1);


        String expressionToMath  = expression.substring(fistDigitInnerParenthesesBegin,firstParenthesesEndIndex);

        String mathExpression = doMath(expressionToMath);

        String resultExpression = leftFromParentheses + mathExpression + rightFromParentheses;
        if(resultExpression.contains("("))
        {
            return handleParenthesesCase(resultExpression);
        }
        else
        return resultExpression;
    }


    private int determinateInnerIndexForRightParentheses(String expression,String parenthesesType, int boundady)
    {
        int index=-1;
        int count=expression.length();
        String after="";
        while (count>=boundady)
        {
            if(isADigit(expression.charAt(count-1))&&after.equals(parenthesesType))
            {
                index=count;
            }
            after=String.valueOf(expression.charAt(count-1));
            count--;
        }
        return index;
    }

    private int determinateInnerIndexForLeftParentheses(String expression,String parenthesesType)
    {
      int i=0;
      int index=-1;
      String after="";
        for (char c: expression.toCharArray())
      {

          if(isADigit(c)&&after.equals(parenthesesType))
          {
             index=i;
          }
          after=String.valueOf(c);
          i++;

      }
        return index;
    }

    private boolean isADigit(char c) {
        return String.valueOf(c).equals("0")
                ||String.valueOf(c).equals("1")
                ||String.valueOf(c).equals("2")
                ||String.valueOf(c).equals("3")
                ||String.valueOf(c).equals("4")
                ||String.valueOf(c).equals("5")
                ||String.valueOf(c).equals("6")
                ||String.valueOf(c).equals("7")
                ||String.valueOf(c).equals("8")
                ||String.valueOf(c).equals("9");
    }


    private String doMath(String expression) {
        return expressionOperator.reduceExpression(expression);
    }


}
