package baseball.model;

import baseball.view.InputView;

public class UserModel {
    public int[] numbers;

    public UserModel() {
        String numberString = InputView.inputThreeNumbers();
        correctNumbers(numberString);
        numbers = new int[numberString.length()];
        int i = 0;
        for (char num : numberString.toCharArray()) {
            this.numbers[i++] = (num - '0');
        }
    }

    private static void correctNumbers(String input) {
        if (input.length() != 3 || !input.matches("[1-9]+"))
            throw new IllegalArgumentException();
    }


}
