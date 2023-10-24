package baseball.Service;

public class Parser {

    public static int[] parseUserInput(String input, int size) throws IllegalArgumentException {
        checkSize(input, size);
        return getParseInt(input, size);
    }

    private static void checkSize(String input, int size) throws IllegalArgumentException {
        if (input.length() != size) {
            throw new IllegalArgumentException();
        }
    }

    private static int[] getParseInt(String input, int size) throws IllegalArgumentException {
        int[] parseInt = new int[size];

        for (int i = 0; i < input.length(); i++) {
            if (!checkDigit(input, i)) {
                throw new IllegalArgumentException();
            }
            parseInt[i] = convertCharToInt(input, i);
        }
        return parseInt;
    }

    private static int convertCharToInt(String input, int i) {
        return input.charAt(i) - '0';
    }

    private static Boolean checkDigit(String input, int i) {
        return '0' <= input.charAt(i) && input.charAt(i) <= '9';
    }
}