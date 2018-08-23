package basicoperation.imp;

import basicoperation.BasicOperation;

public class OperationNotImplemented implements BasicOperation {
    @Override
    public String operate(String firstTerm, String secondTerm) {
       throw new UnsupportedOperationException();
    }
}
