package hu.meiit.haladojava;

import hu.meiit.haladojava.logic.Expression;

public class ExpressionMaker {

    public static Expression parse(String expression) throws ExpressionInvalidException {
        String[] arr = expression.split(" ");
        if (arr.length != 3) {
            String[] strNums = expression.split("[\\+\\-\\*\\/]");
            if (strNums.length != 2) {
                throw new ExpressionInvalidException();
            }
            double[] nums = new double[2];
            for (int i = 0; i < 2; i++) {
                nums[i] = Double.valueOf(strNums[i]);
            }
            String operand = expression.split("[0-9]")[1];
            Expression retExpression = new Expression(nums[0], operand, nums[1]);
        }
        return ret;
    }

}
