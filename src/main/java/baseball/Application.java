package baseball;

import baseball.domain.NumbersBaseballGame;

public class Application {
    public static void main(String[] args) {
        int NUMBER_OF_DIGITS_IN_ANSWER = 3;
        NumbersBaseballGame numbersBaseballGame = new NumbersBaseballGame(NUMBER_OF_DIGITS_IN_ANSWER);
        numbersBaseballGame.run();
    }
}
