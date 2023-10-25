package baseball.util;

public class ConvertInputToArr {

    public static int[] inputToArr(String input) {
        int[] intArr = new int[input.length()];

        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(input.substring(i, i + 1));
        }
        return intArr;
    }

    private ConvertInputToArr() {
    }
}
