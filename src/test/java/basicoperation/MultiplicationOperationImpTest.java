package basicoperation;

import basicoperation.imp.MultiplicationOperationImp;
import org.junit.Assert;
import org.junit.Test;

public class MultiplicationOperationImpTest {

	@Test public void doNothing() {

	}

	@Test public void isClassThere() {
		MultiplicationOperationImp multiplicationOperationImp = new MultiplicationOperationImp();
		Assert.assertNotNull(multiplicationOperationImp);
	}

	@Test public void isMethodThere() {
		MultiplicationOperationImp multiplicationOperationImp = new MultiplicationOperationImp();
		String operateResult = multiplicationOperationImp.operate("0", "0");
		Assert.assertNotNull(operateResult);
	}

	@Test (expected = IllegalArgumentException.class)
	public void methodRequireNotEmtyOrNullInputData() {
		MultiplicationOperationImp multiplicationOperationImp = new MultiplicationOperationImp();
		multiplicationOperationImp.operate("", "");
	}

	@Test public void isAbbleToMakeAddition() {
		MultiplicationOperationImp multiplicationOperationImp = new MultiplicationOperationImp();
		String operateResult = multiplicationOperationImp.operate("0", "0");
		Assert.assertEquals("0",operateResult);
	}

}
