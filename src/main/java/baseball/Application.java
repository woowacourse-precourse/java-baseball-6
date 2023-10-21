package baseball;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        PrintManager printGuide = new PrintManager();
        NumberMaker numberMaker = new NumberMaker();
        InputManager inputManager = new InputManager();
        ScoreCalculator scoreCalculator = new ScoreCalculator();

        printGuide.printGameStart();

        int ball = 0;
        int strike = 0;

        List<Integer> randomNumbers = numberMaker.makeRandomNumbers();
        System.out.println("randomNumbers = " + randomNumbers);

        while (strike != 3) {

            printGuide.printInputValue();

            List<Integer> guessNumbers = inputManager.getGuessNumbers();
            System.out.println("guessNumbers = " + guessNumbers);

            strike = scoreCalculator.computeStrike(randomNumbers, guessNumbers);
            ball = scoreCalculator.computeBall(randomNumbers, guessNumbers, strike);


        }


    }
}
