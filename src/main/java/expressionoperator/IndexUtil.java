package expressionoperator;

import static utils.OperatorSymbolConst.*;

public class IndexUtil {



    public static int determinateFirstOperationIndex(int indexType1, int indexType2) {
        if ((indexType2 == -1 || indexType1 < indexType2) && indexType1 > 0)
            return indexType1;
        else
            return indexType2;
    }


    public  static int determinateIndex(String expression, String s) {
        return expression.indexOf(s);
    }


}
