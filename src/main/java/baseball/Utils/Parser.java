package baseball.Utils;

public class Parser {
    public static int[] parseToInt(String input, int size) throws IllegalArgumentException {
        checkSize(input, size);
        return getParseInt(input, size);
    }

    private static void checkSize(String input, int size) throws IllegalArgumentException {
        var answer = "";

        for (int i = 0; i < input.length(); i++) {
            if (input.indexOf(input.charAt(i)) == i) {
                answer += input.charAt(i);
            }
        }

        if (answer.length() != size) {
            throw new IllegalArgumentException();
        }
    }

    private static int[] getParseInt(String input, int size) throws IllegalArgumentException {
        var parseInt = new int[size];

        for (int i = 0; i < input.length(); i++) {
            if (checkDigital(input, i) == false) {
                throw new IllegalArgumentException();
            }
            parseInt[i] = convertCharToInt(input, i);
        }

        return parseInt;
    }

    private static boolean checkDigital(String input, int index) {
        return '0' < input.charAt(index) && input.charAt(index) <= '9';
    }

    private static int convertCharToInt(String input, int index) {
        return input.charAt(index) - '0';
    }
}
