package baseball.model;

import baseball.view.InputView;

public class UserModel {
    public int[] numbers;

    public UserModel() {
        String numberString = InputView.inputThreeNumbers();
        numbers = Util.stringToIntArray(numberString);
        correctNumbers(numberString);
    }

    private static void correctNumbers(String input) {
        if (input.length() != 3 || !input.matches("[1-9]+") || Util.isDuplicateNumber(input))
            throw new IllegalArgumentException();
    }


}
