package baseball.utils;

public class Parser {

    public int[] parseUserInput(String input, int size) {
        checkSize(input, size);
        return parseInt(input, size);
    }

    private void checkSize(String input, int size) {
        if(input.length() != size) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkDigit(String input, int index) {
        return input.charAt(index) >= '1' && input.charAt(index) <= '9';
    }

    private int convertInt(char c) {
        return c - '0';
    }

    private int[] parseInt(String input, int size) {
        int[] numbers = new int[size];

        for(int i=0; i<size; i++) {
            if(!checkDigit(input, i)){
                throw new IllegalArgumentException();
            }
            numbers[i] = convertInt(input.charAt(i));
        }

        return numbers;
    }
}