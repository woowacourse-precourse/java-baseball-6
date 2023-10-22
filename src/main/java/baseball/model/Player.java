package baseball.model;

import baseball.constant.Constant;

public class Player {
    private int[] numbers = new int[Constant.MAX_DIGIT];

    public Player() {
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(String input) {
        for (int i = 0; i < input.length(); i++) {
            this.numbers[i] = input.charAt(i) - '0';
        }
    }
}
