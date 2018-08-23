package mathoperator.imp;

import basicoperation.BasicOperation;
import factory.basicoperationfactory.OperationAbstractFactory;
import mathoperator.MathOperator;

public class NumberBasicOperator implements MathOperator {

    private OperationAbstractFactory operationAbstractFactory;

    public NumberBasicOperator(OperationAbstractFactory operationAbstractFactory) {
        this.operationAbstractFactory = operationAbstractFactory;
    }

    public String operateBySymbol(String termin1, String termin2, String operation) {

        BasicOperation basicOperation = operationAbstractFactory.create(operation);
        return basicOperation.operate(termin1.replaceAll(" ",""), termin2.replaceAll(" " ,""));

    }
}
