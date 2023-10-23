package baseball.view;

public class RestartInput {

    private int input;

    public RestartInput(String input) {
        if (!hasLengthOfOne(input) || !isDigit(input) || !isOneOrTwo(input)) {
            throw new IllegalArgumentException("1 혹은 2를 입력해주세요");
        }
        this.input = Integer.parseInt(input);
    }

    public int getRestartInput() {
        return input;
    }

    private boolean hasLengthOfOne(String input) {
        return (input.length() == 1);
    }

    private boolean isDigit(String input) {
        return Character.isDigit(input.charAt(0));
    }

    private boolean isOneOrTwo(String input) {
        int number = stringToInt(input);
        return (number == 1 || number == 2);
    }

    private int stringToInt(String input) {
        return Integer.parseInt(input);
    }

}
