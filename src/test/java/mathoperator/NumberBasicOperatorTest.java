package mathoperator;

import factory.basicoperationfactory.OperationAbstractFactory;
import factory.basicoperationfactory.imp.OperationAbstractFactoryImp;
import mathoperator.imp.NumberBasicOperator;
import org.junit.Assert;
import org.junit.Test;

public class NumberBasicOperatorTest {

    @Test
    public void doNothingTest() {

    }

    private OperationAbstractFactory operationAbstractFactory = new OperationAbstractFactoryImp();

    @Test
    public void isClassThere() {
        NumberBasicOperator numberBasicOperator = new NumberBasicOperator(operationAbstractFactory);
        Assert.assertNotNull(numberBasicOperator);
    }


    @Test
    public void isMethodOperateGivenOperatorThere() {
        NumberBasicOperator numberBasicOperator = new NumberBasicOperator(operationAbstractFactory);
        String operate = numberBasicOperator.operateBySymbol("5", "6", "+");
        Assert.assertNotNull(operate);
    }

    @Test
    public void operateTwoTermToAdditionGivenOperator() {
        NumberBasicOperator numberBasicOperator = new NumberBasicOperator(operationAbstractFactory);
        String operate = numberBasicOperator.operateBySymbol("3", "2", "+");
        Assert.assertEquals("5", operate);
    }

    @Test
    public void operateTwoTermToAdditionWithSpaceInTheExpressionGivenOperator() {
        NumberBasicOperator numberBasicOperator = new NumberBasicOperator(operationAbstractFactory);
        String operate = numberBasicOperator.operateBySymbol("   3 ", "     2   ", "+");

        Assert.assertEquals("5", operate);
    }


    @Test
    public void operateTwoTermToMultiplicationGivenOperator() {
        NumberBasicOperator numberBasicOperator = new NumberBasicOperator(operationAbstractFactory);
        String operate = numberBasicOperator.operateBySymbol("3", "2", "*");
        Assert.assertEquals("6", operate);
    }

    @Test
    public void operateTwoTermToMultiplicationWithSpaceInTheExpressionGivenOperator() {
        NumberBasicOperator numberBasicOperator = new NumberBasicOperator(operationAbstractFactory);
        String operate = numberBasicOperator.operateBySymbol("   3 ", "     2   ", "*");
        Assert.assertEquals("6", operate);
    }

    @Test
    public void isMethodOperateGivenOperatorOneIsNegativeThere() {
        NumberBasicOperator numberBasicOperator = new NumberBasicOperator(operationAbstractFactory);
        String operate = numberBasicOperator.operateBySymbol("-5", "6", "+");
        Assert.assertEquals("1", operate);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void isMethodOperateForAnNonExistingSymbol() {
        NumberBasicOperator numberBasicOperator = new NumberBasicOperator(operationAbstractFactory);
        String operate = numberBasicOperator.operateBySymbol("-5", "6", "!");
        Assert.assertEquals("1", operate);
    }


}
