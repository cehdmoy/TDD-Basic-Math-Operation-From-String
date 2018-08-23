package factory.expressionoperatorfactory.imp;

import expressionoperator.ExpressionOperator;
import expressionoperator.imp.OperatorDiffKindOfSymolImp;
import expressionoperator.imp.OperatorForSameOperationKindImp;
import factory.basicoperationfactory.imp.OperationAbstractFactoryImp;
import factory.expressionoperatorfactory.ExpressionOperatorAbstracFactory;
import mathoperator.imp.NumberBasicOperator;

import static utils.OperatorSymbolConst.*;

public class OperatorDiffKindOfSymbolFactory implements ExpressionOperatorAbstracFactory {
    @Override
    public ExpressionOperator create() {
        NumberBasicOperator numberBasicOperator = new NumberBasicOperator(new OperationAbstractFactoryImp());
        OperatorForSameOperationKindImp addKindOperator = new OperatorForSameOperationKindImp(PLUS, DASH, numberBasicOperator);
        OperatorForSameOperationKindImp multKindOperator = new OperatorForSameOperationKindImp(ASTERISK, WHACK, numberBasicOperator);
        return new OperatorDiffKindOfSymolImp(addKindOperator, multKindOperator);
    }
}
