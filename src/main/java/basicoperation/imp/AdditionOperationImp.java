package basicoperation.imp;

import basicoperation.BasicOperation;

public class AdditionOperationImp implements BasicOperation {

	public String operate(String firstTerm, String secondTerm) {
		if(firstTerm.isEmpty() || secondTerm.isEmpty())
		{
			throw new IllegalArgumentException();
		}
		else {
			int intResult = Integer.parseInt(firstTerm) + Integer.parseInt(secondTerm);
			return String.valueOf(intResult);
		}
	}
}
