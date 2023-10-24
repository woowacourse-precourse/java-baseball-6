package baseball.utils;

public class Parser {

    public int[] parseUserInput(String input) {
        checkSize(input);
        return parseInt(input);
    }

    private void checkSize(String input) {
        if(input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkDigit(String input, int index) {
        return input.charAt(index) >= '1' && input.charAt(index) <= '9';
    }

    private int convertInt(char c) {
        return c - '0';
    }

    private int[] parseInt(String input) {
        int[] numbers = new int[3];

        for(int i=0; i<input.length(); i++) {
            if(!checkDigit(input, i)){
                throw new IllegalArgumentException();
            }
            numbers[i] = convertInt(input.charAt(i));
        }

        return numbers;
    }
}