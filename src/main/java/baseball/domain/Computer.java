package baseball.domain;

import static baseball.validation.NumbersValidator.validation;

import baseball.Constants;

public class Computer {

    private final String numbers;

    public Computer(String numbers) {
        validation(numbers);
        this.numbers = numbers;
    }

    public Score getScore(String userInput) {
        validation(userInput);
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < Constants.NUMBER_SIZE; ++i) {
            char userNumber = userInput.charAt(i);
            if (this.numbers.charAt(i) == userNumber) {
                ++strike;
            } else if (this.numbers.contains(String.valueOf(userNumber))) {
                ++ball;
            }
        }
        return new Score(ball, strike);
    }
}
