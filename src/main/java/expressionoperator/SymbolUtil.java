package expressionoperator;

import static utils.OperatorSymbolConst.*;

public class SymbolUtil {

    public static boolean isABasicOperationMathSymbol(String insideExpression) {
        return insideExpression.contains(PLUS) ||
                insideExpression.contains(ASTERISK) ||
                insideExpression.contains(DASH)
                || insideExpression.contains(WHACK);
    }

    public static boolean doesExpresionHaveMathOpetationToResolve(String insideExpression) {
        return isABasicOperationMathSymbol(insideExpression) && !String.valueOf(insideExpression.charAt(0)).equals(DASH)
                && !String.valueOf(insideExpression.charAt(0)).equals(PLUS);
    }


}
