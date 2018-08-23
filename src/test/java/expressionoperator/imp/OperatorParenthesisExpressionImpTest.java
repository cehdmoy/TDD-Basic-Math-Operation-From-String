package expressionoperator.imp;

import expressionoperator.ExpressionOperator;
import factory.expressionoperatorfactory.imp.OperatorDiffKindOfSymbolFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OperatorParenthesisExpressionImpTest {


    private ExpressionOperator expressionOperator;

    @Before
    public void setUp() {

        ExpressionOperator operatorDiffKindOfSymolImp = new OperatorDiffKindOfSymbolFactory().create();
        expressionOperator = new OperatorParenthesisExpressionImp(operatorDiffKindOfSymolImp);
    }

    private String getReduceExpression(String s) {
        return expressionOperator.reduceExpression(s);
    }

    private void validateExpression(String reduceExpression, String s) {
        Assert.assertEquals(s, reduceExpression);
    }

    @Test
    public void doesClassImplementExpressionOperator() {
        Assert.assertNotNull(expressionOperator);
    }

    @Test
    public void operateCase1() {
        String reduceExpression = getReduceExpression("()");
        validateExpression(reduceExpression, "Cannot operate empty expression");

    }

    @Test
    public void operateCase2() {
        String reduceExpression = getReduceExpression("(4)");
        validateExpression(reduceExpression, "4");
    }

    @Test
    public void operateCase3() {
        String reduceExpression = getReduceExpression("(4+1)");
        validateExpression(reduceExpression, "5");
    }

    @Test
    public void operateCase4() {
        String reduceExpression = getReduceExpression("(4*1)");
        validateExpression(reduceExpression, "4");
    }

    @Test
    public void operateCase5() {
        String reduceExpression = getReduceExpression("(4-1)");
        validateExpression(reduceExpression, "3");
    }

    @Test
    public void operateCase6() {
        String reduceExpression = getReduceExpression("(4/1)");
        validateExpression(reduceExpression, "4");
    }

    @Test
    public void operateCase7() {
        String reduceExpression = getReduceExpression("(-4)");
        validateExpression(reduceExpression, "-4");
    }

    @Test
    public void operateCase8() {
        String reduceExpression = getReduceExpression("(4/1)+1");
        validateExpression(reduceExpression, "4+1");
    }



    @Test
    public void operateCase9() {
        String reduceExpression = getReduceExpression("(5-3)*3");
        validateExpression(reduceExpression, "2*3");
    }

    @Test
    public void operateCase10() {
        String reduceExpression = getReduceExpression("10+(6-1)");
        validateExpression(reduceExpression, "10+5");
    }

    @Test
    public void operateCase11() {
        String reduceExpression = getReduceExpression("10+(6-1)+2");
        validateExpression(reduceExpression, "10+5+2");
    }

    @Test
    public void operateCase12() {
        String reduceExpression = getReduceExpression("10+(6-1)*2");
        validateExpression(reduceExpression, "10+5*2");
    }

    @Test
    public void operateCase13() {
        String reduceExpression = getReduceExpression("10-(6-1)*2");
        validateExpression(reduceExpression, "10-5*2");
    }

    @Test
    public void operateCase14() {
        String reduceExpression = getReduceExpression("10-(6-1)*2+2");
        validateExpression(reduceExpression, "10-5*2+2");
    }


    @Test
    public void operateCase15() {
        String reduceExpression = getReduceExpression("((6))");
        validateExpression(reduceExpression, "6");
    }

    @Test
    public void operateCase16() {
        String reduceExpression = getReduceExpression("((6*2)+1)");
        validateExpression(reduceExpression, "13");
    }

    @Test
    public void operateCase17() {
        String reduceExpression = getReduceExpression("(6*(2+1))");
        validateExpression(reduceExpression, "18");
    }

    @Test
    public void operateCase18() {
        String reduceExpression = getReduceExpression("(6*(2+1))+1");
        validateExpression(reduceExpression, "18+1");
    }

    @Test
    public void operateCase19() {
        String reduceExpression = getReduceExpression("4*(6*(2+1))+1");
        validateExpression(reduceExpression, "4*18+1");
    }

    @Test
    public void operateCase20() {
        String reduceExpression = getReduceExpression("12+4*(6*(2+1))");
        validateExpression(reduceExpression, "12+4*18");
    }


    @Test
    public void operateCase21() {
        String reduceExpression = getReduceExpression("(12/2)+(12/3)");
        validateExpression(reduceExpression, "6+4");
    }

    @Test
    public void operateCase22() {
        String reduceExpression = getReduceExpression("5+(12/2)+(12/3)");
        validateExpression(reduceExpression, "5+6+4");
    }

    @Test
    public void operateCase23() {
        String reduceExpression = getReduceExpression("(12/2)+6+(12/3)");
        validateExpression(reduceExpression, "6+6+4");
    }

    @Test
    public void operateCase24() {
        String reduceExpression = getReduceExpression("(12/2)+6+(12/3)+55");
        validateExpression(reduceExpression, "6+6+4+55");
    }

    @Test
    public void operateCase25() {
        String reduceExpression = getReduceExpression("((12/2)+6+(12/3)+55)");
        validateExpression(reduceExpression, "71");
    }

    @Test
    public void operateCase26() {
        String realData ="((16+4)/5-(5+8)*(1-2))";
        String reduceExpression = getReduceExpression(realData);
        validateExpression(reduceExpression, "17");
    }
    
    @Test
    public void operateCase27() {
        String realData ="(5*9-3+(2-1)*(9-(24/8)))";
        String reduceExpression = getReduceExpression(realData);
        validateExpression(reduceExpression, "48");
    }
   
    @Test
    public void operateCase28() {
        String realData ="((((15-5)*5)/2)+(8-2)*(25+2))";
        String reduceExpression = getReduceExpression(realData);
        validateExpression(reduceExpression, "187");
    }

}

