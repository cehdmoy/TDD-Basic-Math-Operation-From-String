package factory.basicoperationfactory.imp;

import basicoperation.BasicOperation;
import basicoperation.imp.*;
import factory.basicoperationfactory.OperationAbstractFactory;
import utils.OperatorSymbolConst;

import static utils.OperatorSymbolConst.DASH;

public class OperationAbstractFactoryImp implements OperationAbstractFactory {

    @Override
    public BasicOperation create(String operationSym) {
        if (operationSym.equals(OperatorSymbolConst.PLUS)) {
            return new AdditionOperationImp();
        } else if (operationSym.contains(OperatorSymbolConst.ASTERISK)) {
            return new MultiplicationOperationImp();
        } else if (operationSym.contains(DASH)) {
            return new SubtractionOperationImp();
        } else if (operationSym.equals(OperatorSymbolConst.WHACK)) {
            return new DivOperationImp();
        } else
            return new OperationNotImplemented();
    }
}
