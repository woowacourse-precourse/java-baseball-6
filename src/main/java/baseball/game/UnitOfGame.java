package baseball.game;

import baseball.numbers.NumbersGenerator;
import baseball.numbers.UserNumbersGenerator;
import java.util.List;

public class UnitOfGame {
    private final List<Integer> computerNumbers;

    public UnitOfGame(NumbersGenerator numbersGenerator) {
        this.computerNumbers = numbersGenerator.generate();
    }

    public void play() {
        NumbersGenerator numbersGenerator;
        List<Integer> userNumbers;
        int ball;
        int strike;

        do {
            numbersGenerator = new UserNumbersGenerator();
            userNumbers = numbersGenerator.generate();
            ball = CalculateScore.countBall(computerNumbers, userNumbers);
            strike = CalculateScore.countStrike(computerNumbers, userNumbers);
            UnitOfGameResult.printResult(ball, strike);
        } while (strike != 3);
    }


}
