package baseball.util;

public class Converter {
    public static int[] convertToArray(String input) {
        int[] numbers = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            numbers[i] = Character.getNumericValue(input.charAt(i));
        }
        return numbers;
    }
}
