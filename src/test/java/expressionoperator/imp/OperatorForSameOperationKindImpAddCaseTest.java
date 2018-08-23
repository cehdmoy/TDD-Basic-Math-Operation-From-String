package expressionoperator.imp;

import factory.basicoperationfactory.imp.OperationAbstractFactoryImp;
import mathoperator.imp.NumberBasicOperator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OperatorForSameOperationKindImpAddCaseTest {


    private OperatorForSameOperationKindImp operatorForSameOperationKindImp;

    @Before
    public void setUp() {
        NumberBasicOperator numberBasicOperator = new NumberBasicOperator(new OperationAbstractFactoryImp());
        operatorForSameOperationKindImp = new OperatorForSameOperationKindImp("+", "-", numberBasicOperator);
    }

    @Test
    public void isClassThere() {
        Assert.assertNotNull(operatorForSameOperationKindImp);
    }


    @Test
    public void operateBinaryAddition() {
        String operateExpression = operatorForSameOperationKindImp.reduceExpression("5+9");
        Assert.assertEquals("14", operateExpression);
    }

    @Test
    public void operateTernaryAddition() {
        String operateExpression = operatorForSameOperationKindImp.reduceExpression("5+9+10");
        Assert.assertEquals("24", operateExpression);
    }

    @Test
    public void operateMoreThanThreeTerms() {

        String operateExpression = operatorForSameOperationKindImp.reduceExpression("1+1+2+3+5+8");
        Assert.assertEquals("20", operateExpression);

    }

    @Test
    public void operateTwoTermsBasicSubtractionTest() {
        String operateExpression = operatorForSameOperationKindImp.reduceExpression("3-2");
        Assert.assertEquals("1", operateExpression);
    }

    @Test
    public void operateThreeTermsBasicSubtractionTest() {
        String operateExpression = operatorForSameOperationKindImp.reduceExpression("5-2-1");
        Assert.assertEquals("2", operateExpression);
    }

    @Test
    public void substractionMoreThanThreeTermsTest() {
        String operateExpression = operatorForSameOperationKindImp.reduceExpression("10-1-2-3-4");
        Assert.assertEquals("0", operateExpression);
    }

    @Test
    public void mixOperations() {
        String operateExpression = operatorForSameOperationKindImp.reduceExpression("1+10-1-2-3-4");
        Assert.assertEquals("1", operateExpression);
    }

    @Test
    public void largeListOfTermsOperationMixed() {
        String operateExpression = operatorForSameOperationKindImp.reduceExpression("1+10-1-2-3-4+44-2345+213432534-5+66-1-8-9-0+0+9+8+7+6+5+4+3+5+6+7+6+5-6+7+7+4");
        Assert.assertEquals("213430360", operateExpression);
    }

    @Test
    public void operateNegativeValue() {
        String operateExpression = operatorForSameOperationKindImp.reduceExpression("5+-9");
        Assert.assertEquals("-4", operateExpression);
    }
}
