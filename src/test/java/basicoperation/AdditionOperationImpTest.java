package basicoperation;

import basicoperation.imp.AdditionOperationImp;
import org.junit.Assert;
import org.junit.Test;

public class AdditionOperationImpTest {

	@Test public void doNothing() {

	}

	@Test public void isClassThere() {
		AdditionOperationImp additionOperationImp = new AdditionOperationImp();
		Assert.assertNotNull(additionOperationImp);
	}

	@Test public void isMethodThere() {
		AdditionOperationImp additionOperationImp = new AdditionOperationImp();
		String operateResult = additionOperationImp.operate("0", "0");
		Assert.assertNotNull(operateResult);
	}

	@Test (expected = IllegalArgumentException.class)
	public void methodRequireNotEmtyOrNullInputData() {
		AdditionOperationImp additionOperationImp = new AdditionOperationImp();
		additionOperationImp.operate("", "");
	}

	@Test public void isAbbleToMakeAddition() {
		AdditionOperationImp additionOperationImp = new AdditionOperationImp();
		String operateResult = additionOperationImp.operate("0", "0");
		Assert.assertEquals("0",operateResult);
	}
}
