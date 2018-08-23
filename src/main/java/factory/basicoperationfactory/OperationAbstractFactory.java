package factory.basicoperationfactory;

import basicoperation.BasicOperation;

public interface OperationAbstractFactory {

    BasicOperation create(String operationSym);

}
