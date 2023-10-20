package baseball;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        PrintGuide printGuide = new PrintGuide();
        NumberMaker numberMaker = new NumberMaker();
        InputManager inputManager = new InputManager();

        printGuide.printGameStart();

        List<Integer> randomNumbers = numberMaker.makeRandomNumbers();
        System.out.println(randomNumbers);

        String guessNumbers = inputManager.getGuessNumbers();



    }
}
