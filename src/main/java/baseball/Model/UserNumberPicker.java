package baseball.Model;

import baseball.View.InputView;

public class UserNumberPicker {
    public final int[] user;

    public UserNumberPicker() throws IllegalArgumentException {
        String userInput = InputView.requestBaseballNumber();
        if(isException(userInput)) {
            throw new IllegalArgumentException();
        }
        this.user = convertStringToIntArray(userInput);
    }

    private int[] convertStringToIntArray(String userInput) {
        int[] user = new int[GameConstant.MAX_NUM];
        for (int i = 0; i < userInput.length(); i++) {
            user[i] = userInput.charAt(i) - '0';
        }
        return user;
    }

    private boolean isException(String userInput) {
        return !Exception.checkIsNumber(userInput) || Exception.checkIsDuplicated(userInput) || !Exception.checkInputLength(userInput) || Exception.checkIsZero(userInput);
    }
}
