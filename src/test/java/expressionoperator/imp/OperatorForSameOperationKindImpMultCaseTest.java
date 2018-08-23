package expressionoperator.imp;

import factory.basicoperationfactory.imp.OperationAbstractFactoryImp;
import mathoperator.imp.NumberBasicOperator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OperatorForSameOperationKindImpMultCaseTest {

    private OperatorForSameOperationKindImp operatorForSameOperationKindImp;

    @Before
    public void setUp() {
        NumberBasicOperator numberBasicOperator = new NumberBasicOperator(new OperationAbstractFactoryImp());
        operatorForSameOperationKindImp = new OperatorForSameOperationKindImp("*", "/", numberBasicOperator);
    }

    @Test
    public void isClassThere() {
        Assert.assertNotNull(operatorForSameOperationKindImp);
    }

    @Test
    public void isMethodOperateExpressionThere() {
        String expression = "2*4";
        operatorForSameOperationKindImp.reduceExpression(expression);
    }

    @Test
    public void isMethodOperateExpressionThereReturningNotNull() {
        String expression = "2*4";
        String operateExpressionResult = operatorForSameOperationKindImp.reduceExpression(expression);
        Assert.assertNotNull(operateExpressionResult);
    }

    @Test
    public void isAbleToOperateTwoTerm() {
        String expression = "2*4";
        String operateExpressionResult = operatorForSameOperationKindImp.reduceExpression(expression);
        Assert.assertEquals("8", operateExpressionResult);
    }

    @Test
    public void operateMoreThreeTerm() {
        String expression = "2*4*3";
        String operateExpressionResult = operatorForSameOperationKindImp.reduceExpression(expression);
        Assert.assertEquals("24", operateExpressionResult);
    }

    @Test
    public void operateMoreThreeTermAndDivByValidNumber() {
        String expression = "2*4*3/6";
        String operateExpressionResult = operatorForSameOperationKindImp.reduceExpression(expression);
        Assert.assertEquals("4", operateExpressionResult);
    }

    @Test
    public void isAbleToOperateTwoTermNegative() {
        String expression = "2*-4";
        String operateExpressionResult = operatorForSameOperationKindImp.reduceExpression(expression);
        Assert.assertEquals("-8", operateExpressionResult);
    }
}
