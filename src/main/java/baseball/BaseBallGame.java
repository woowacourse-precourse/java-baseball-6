package baseball;

import java.util.List;

public class BaseBallGame {

    public void doBaseBallGame() {

        PrintManager printManager = new PrintManager();
        NumberMaker numberMaker = new NumberMaker();
        InputManager inputManager = new InputManager();
        ScoreCalculator scoreCalculator = new ScoreCalculator();

        printManager.printGameStart();

        int ball = 0;
        int strike = 0;

        List<Integer> randomNumbers = numberMaker.makeRandomNumbers();
        System.out.println("randomNumbers = " + randomNumbers);

        while (strike != 3) {

            printManager.printInputValue();

            List<Integer> guessNumbers = inputManager.getGuessNumbers();
            System.out.println("guessNumbers = " + guessNumbers);

            strike = scoreCalculator.computeStrike(randomNumbers, guessNumbers);
            ball = scoreCalculator.computeBall(randomNumbers, guessNumbers, strike);

            printManager.printResult(strike, ball);

        }

        printManager.printGameOver();
    }

}
