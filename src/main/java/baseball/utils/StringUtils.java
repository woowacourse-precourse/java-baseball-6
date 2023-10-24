package baseball.utils;


public class StringUtils {

    private StringUtils() {
    }

    public static int[] parseStringToIntArray(String inputString) {
        String[] array = inputString.split("");
        int[] numberArray = new int[3];
        for (int i = 0; i < 3; i++) {
            numberArray[i] = Integer.parseInt(array[i]);
        }
        return numberArray;
    }

}
