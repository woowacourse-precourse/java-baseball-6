package baseball;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        PrintGuide printGuide = new PrintGuide();
        NumberMaker numberMaker = new NumberMaker();
        InputManager inputManager = new InputManager();
        ScoreCalculator scoreCalculator = new ScoreCalculator();

        printGuide.printGameStart();

        List<Integer> randomNumbers = numberMaker.makeRandomNumbers();
        System.out.println("randomNumbers = " + randomNumbers);

        printGuide.printInputValue();

        List<Integer> guessNumbers = inputManager.getGuessNumbers();
        System.out.println("guessNumbers = " + guessNumbers);

        scoreCalculator.doCalculate(randomNumbers, guessNumbers);

    }
}
