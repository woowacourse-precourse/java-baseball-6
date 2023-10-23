package baseball.Model;

import baseball.View.InputView;

public class UserNumberPicker {
    public final int[] user;

    public UserNumberPicker() {
        String userInput = InputView.requestBaseballNumber();
        this.user = convertStringToIntArray(userInput);
    }

    private int[] convertStringToIntArray(String userInput) {
        int[] user = new int[3];
        for (int i = 0; i < userInput.length(); i++) {
            user[i] = userInput.charAt(i) - '0';
        }
        return user;
    }
}
