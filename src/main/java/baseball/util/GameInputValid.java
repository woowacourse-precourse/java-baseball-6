package baseball.util;


public class GameInputValid implements UserInputValid {

    @Override
    public void inputValid(String input) throws IllegalArgumentException {
        // 사용자로부터 입력 받은 값이 숫자가 아닌 경우
        compareInputType(input);
    }

    private void compareInputType(String input) throws IllegalArgumentException {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumeric(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
