package expressionoperator.imp;

import expressionoperator.ExpressionOperator;
import factory.expressionoperatorfactory.imp.OperatorDiffKindOfSymbolFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OperatorDiffKindOfSymolImpTest {

    private ExpressionOperator operatorDiffKindOfSymolImp;

    @Before
    public void setUp() {

        operatorDiffKindOfSymolImp = new OperatorDiffKindOfSymbolFactory().create();
    }

    @Test
    public void isClassThere() {
        Assert.assertNotNull(operatorDiffKindOfSymolImp);
    }

    @Test
    public void isExpressionOperatorType() {
        ExpressionOperator expressionOperator = operatorDiffKindOfSymolImp;
        Assert.assertNotNull(expressionOperator);
    }

    @Test
    public void cannotOperateEmptyExpression() {
        ExpressionOperator expressionOperator = operatorDiffKindOfSymolImp;
        String reducedExpression = expressionOperator.reduceExpression("");
        Assert.assertEquals("Expression must not be empty", reducedExpression);
    }

    @Test
    public void case0Test() {

        ExpressionOperator expressionOperator = operatorDiffKindOfSymolImp;
        String reducedExpression = expressionOperator.reduceExpression("13");
        Assert.assertEquals("13", reducedExpression);
    }

    @Test
    public void case1Test() {

        ExpressionOperator expressionOperator = operatorDiffKindOfSymolImp;
        String reducedExpression = expressionOperator.reduceExpression("1+3");
        Assert.assertEquals("4", reducedExpression);
    }

    @Test
    public void case2Test() {

        ExpressionOperator expressionOperator = operatorDiffKindOfSymolImp;
        String reducedExpression = expressionOperator.reduceExpression("2*3");
        Assert.assertEquals("6", reducedExpression);
    }

    @Test
    public void case3Test() {
        ExpressionOperator expressionOperator = operatorDiffKindOfSymolImp;
        String reducedExpression = expressionOperator.reduceExpression("2+3*5");
        Assert.assertEquals("17", reducedExpression);
    }

    @Test
    public void case4Test() {
        ExpressionOperator expressionOperator = operatorDiffKindOfSymolImp;
        String reducedExpression = expressionOperator.reduceExpression("2-5*3");
        Assert.assertEquals("-13", reducedExpression);
    }

    @Test
    public void case5Test() {
        ExpressionOperator expressionOperator = operatorDiffKindOfSymolImp;
        String reducedExpression = expressionOperator.reduceExpression("2+6/3");
        Assert.assertEquals("4", reducedExpression);
    }

    @Test
    public void case6Test() {
        ExpressionOperator expressionOperator = operatorDiffKindOfSymolImp;
        String reducedExpression = expressionOperator.reduceExpression("2-6/3");
        Assert.assertEquals("0", reducedExpression);
    }

    @Test
    public void case7Test() {
        ExpressionOperator expressionOperator = operatorDiffKindOfSymolImp;
        String reducedExpression = expressionOperator.reduceExpression("5*3+2");
        Assert.assertEquals("17", reducedExpression);
    }

    @Test
    public void case8Test() {
        ExpressionOperator expressionOperator = operatorDiffKindOfSymolImp;
        String reducedExpression = expressionOperator.reduceExpression("6/3+2");
        Assert.assertEquals("4", reducedExpression);
    }

    @Test
    public void case9Test() {
        ExpressionOperator expressionOperator = operatorDiffKindOfSymolImp;
        String reducedExpression = expressionOperator.reduceExpression("5*3-2");
        Assert.assertEquals("13", reducedExpression);
    }

    @Test
    public void case10Test() {
        ExpressionOperator expressionOperator = operatorDiffKindOfSymolImp;
        String reducedExpression = expressionOperator.reduceExpression("6/3-2");
        Assert.assertEquals("0", reducedExpression);
    }

    @Test
    public void case11Test() {
        ExpressionOperator expressionOperator = operatorDiffKindOfSymolImp;
        String reducedExpression = expressionOperator.reduceExpression("5+2*2+1");
        Assert.assertEquals("10", reducedExpression);
    }

    @Test
    public void case12Test() {
        ExpressionOperator expressionOperator = operatorDiffKindOfSymolImp;
        String reducedExpression = expressionOperator.reduceExpression("2*2+1+5");
        Assert.assertEquals("10", reducedExpression);
    }

    @Test
    public void case13Test() {
        ExpressionOperator expressionOperator = operatorDiffKindOfSymolImp;
        String reducedExpression = expressionOperator.reduceExpression("5+2/2+1");
        Assert.assertEquals("7", reducedExpression);
    }

    @Test
    public void case14Test() {
        ExpressionOperator expressionOperator = operatorDiffKindOfSymolImp;
        String reducedExpression = expressionOperator.reduceExpression("7*22/7+15/3");
        Assert.assertEquals("27", reducedExpression);
    }

    @Test
    public void case15Test() {
        ExpressionOperator expressionOperator = operatorDiffKindOfSymolImp;
        String reducedExpression = expressionOperator.reduceExpression("10-4+5/5+1");
        Assert.assertEquals("8", reducedExpression);
    }

    @Test
    public void case16Test() {
        ExpressionOperator expressionOperator = operatorDiffKindOfSymolImp;
        String reducedExpression = expressionOperator.reduceExpression("22+-12");
        Assert.assertEquals("10", reducedExpression);
    }

    @Test
    public void case17Test() {
        ExpressionOperator expressionOperator = operatorDiffKindOfSymolImp;
        String reducedExpression = expressionOperator.reduceExpression("5/-5");
        Assert.assertEquals("-1", reducedExpression);
    }

    @Test
    public void case18Test() {
        ExpressionOperator expressionOperator = operatorDiffKindOfSymolImp;
        String reducedExpression = expressionOperator.reduceExpression("5*-5");
        Assert.assertEquals("-25", reducedExpression);
    }

    @Test
    public void case19Test() {
        ExpressionOperator expressionOperator = operatorDiffKindOfSymolImp;
        String reducedExpression = expressionOperator.reduceExpression("5+-5");
        Assert.assertEquals("0", reducedExpression);
    }

    @Test
    public void case20Test() {
        ExpressionOperator expressionOperator = operatorDiffKindOfSymolImp;
        String reducedExpression = expressionOperator.reduceExpression("5--5");
        Assert.assertEquals("10", reducedExpression);
    }


    @Test
    public void case21Test() {
        ExpressionOperator expressionOperator = operatorDiffKindOfSymolImp;
        String reducedExpression = expressionOperator.reduceExpression("47-21+5+7*22/7");//+15/3+21/3+22*1+3*7-33");
        Assert.assertEquals("53", reducedExpression);
    }

    @Test
    public void caseIntegrationTest() {
        ExpressionOperator expressionOperator = operatorDiffKindOfSymolImp;
        String reducedExpression = expressionOperator.reduceExpression("47-21+5+7*22/7+15/3+21/3+22*1+3*7-33+22/2-1+1000");
        Assert.assertEquals("1085", reducedExpression);
    }

}
