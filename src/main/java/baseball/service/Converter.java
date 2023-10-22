package baseball.service;

public class Converter {
    private static final int NUMBER_SIZE = 3;
    private static final int ARRAY_SIZE = 10;

    public static int[] convert(String num) {
        int[] arr = new int[ARRAY_SIZE];
        for (int i = 0; i < NUMBER_SIZE; i++) {
            arr[num.charAt(i) - '0']++;
        }
        return arr;
    }
}
