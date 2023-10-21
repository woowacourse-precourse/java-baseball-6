package baseball;

import java.util.List;

public class BaseBallGame {

    PrintManager printManager = new PrintManager();
    NumberMaker numberMaker = new NumberMaker();
    InputManager inputManager = new InputManager();
    ScoreCalculator scoreCalculator = new ScoreCalculator();

    public void doBaseBallGame() {

        int ball = 0;
        int strike = 0;

        List<Integer> randomNumbers = numberMaker.makeRandomNumbers();

        while (strike != 3) {

            printManager.printInputValue();

            List<Integer> guessNumbers = inputManager.getGuessNumbers();

            strike = scoreCalculator.computeStrike(randomNumbers, guessNumbers);
            ball = scoreCalculator.computeBall(randomNumbers, guessNumbers, strike);

            printManager.printResult(strike, ball);

        }

        printManager.printGameOver();

    }

}
