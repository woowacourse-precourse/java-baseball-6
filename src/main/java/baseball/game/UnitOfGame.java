package baseball.game;

import baseball.Constants;
import baseball.numbers.NumbersGenerator;
import baseball.numbers.UserNumbersGenerator;
import java.util.List;

public class UnitOfGame extends Game {
    private final List<Integer> computerNumbers;

    public UnitOfGame(NumbersGenerator numbersGenerator) {
        this.computerNumbers = numbersGenerator.generate();
    }

    @Override
    public void play() {
        int strike;

        do {
            NumbersGenerator numbersGenerator = new UserNumbersGenerator();
            List<Integer> userNumbers = numbersGenerator.generate();
            int ball = CalculateScore.countBall(computerNumbers, userNumbers);
            strike = CalculateScore.countStrike(computerNumbers, userNumbers);
            GameView.printAfterUnitOfGame(ball, strike);
        } while (strike != Constants.SCORE_OF_STRIKE);
    }
}
