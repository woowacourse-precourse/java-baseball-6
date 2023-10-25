package baseball.utils;

public class Parser {
    public int[] parseUserInput(String input, int size) throws IllegalArgumentException {
        if (input.length() != size) {
            throw new IllegalArgumentException();
        }
        return getParseInt(input, size);
    }

    private int[] getParseInt(String input, int size) {
        int[] parseInt = new int[size];
        for (int i = 0; i < input.length(); i++) {
            if (!checkDigit(input, i)) {
                throw new IllegalArgumentException();
            }
            parseInt[i] = input.charAt(i) - '0';
        }
        return parseInt;
    }

    private Boolean checkDigit(String input, int i) {
        return '0' <= input.charAt(i) && input.charAt(i) <= 9;
    }
}
