package baseball.util;

public class Parser {
    public int[] parseUserInput(String input, int size) throws IllegalArgumentException {
        checkSize(input, size);
        return getParseInt(input, size);
    }

    private void checkSize(String input, int size) throws IllegalArgumentException {
        if (input.length() != size) {
            throw new IllegalArgumentException();
        }
    }

    private Boolean checkNumber(String input, int i) {
        return '0' <= input.charAt(i) && input.charAt(i) <= '9';
    }

    private int convertCharToInt(String input, int i) {
        return input.charAt(i) - '0';
    }

    private int[] getParseInt(String input, int size) throws IllegalArgumentException {
        int[] parseInt = new int[size];

        for (int i = 0; i < input.length(); i++) {
            if (!checkNumber(input, i)) {
                throw new IllegalArgumentException();
            }
            parseInt[i] = convertCharToInt(input, i);
        }
        return parseInt;
    }
}
