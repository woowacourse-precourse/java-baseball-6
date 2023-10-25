package baseball.utils;

public class Parser {
    private Boolean checkDigit(String input, int i) {
        return '0' <= input.charAt(i) && input.charAt(i) <= 9;
    }
}
