package baseball.utils;

public class Parser {

    // 입력값받아 크기, 숫자 검증 후 정수 배열로 변환
    public int[] parseUserInput(String input, int size) {
        checkSize(input, size);
        return parseInt(input, size);
    }

    // 입력값 크기 검증
    private void checkSize(String input, int size) throws IllegalArgumentException {
        if(input.length() != size) {
            throw new IllegalArgumentException();
        }
    }

    // 입력값 숫자 검증
    private boolean checkDigit(String input, int index) {
        return input.charAt(index) >= '1' && input.charAt(index) <= '9';
    }

    // 문자를 정수로 변환
    private int convertInt(char c) {
        return c - '0';
    }

    // 입력값 숫자 검증 후 정수 배열로 변환
    private int[] parseInt(String input, int size) throws IllegalArgumentException {
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