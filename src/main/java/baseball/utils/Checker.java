package baseball.utils;

public class Checker {
    public int[] checkUserInput(String input, int size) throws IllegalArgumentException {
        checkSize(input, size);
        return getCheckInt(input, size);
    }

    private void checkSize(String input, int size) throws IllegalArgumentException {
        if (input.length() != size) {
            throw new IllegalArgumentException();
        }
    }

    private int[] getCheckInt(String input, int size) throws IllegalArgumentException {
        int[] checkInt = new int[size];

        for (int i = 0; i < input.length(); i++) {
            if (!checkDigit(input, i)) {
                throw new IllegalArgumentException();
            }
            checkInt[i] = convertCharToInt(input, i);
        }
        return checkInt;
    }

    private int convertCharToInt(String input, int i) {
        return input.charAt(i) - '0';
    }

    private Boolean checkDigit(String input, int i) {
        return '1' <= input.charAt(i) && input.charAt(i) <= '9';
    }
}

