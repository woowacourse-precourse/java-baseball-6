package global.utils;

public class ParseUtil {
    public int[] parseInput(String input, int size) {
        validateSize(input, size);
        return getParseInt(input, size);
    }

    private void validateSize(String input, int size) {
        if (input.length() != size) {
            throw new IllegalArgumentException();
        }
    }

    private int[] getParseInt(String input, int size) {
        int[] parseInt = new int[size];
        for (int i = 0; i < input.length(); i++) {
            if (!validateDigit(i, input)) {
                throw new IllegalArgumentException();
            }
            parseInt[i] = convertCharToInt(i, input);
        }
        return parseInt;
    }

    private boolean validateDigit(int i, String input) {
        return '1' <= input.charAt(i) && input.charAt(i) <= '9';
    }

    private int convertCharToInt(int i, String input) {
        return input.charAt(i) - '0';
    }
}
