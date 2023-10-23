package baseball;

import java.util.List;
import java.util.Map;

public class BaseBallGame {
    private final Input input;
    private final Output output;
    private final Computer computer;

    public BaseBallGame() {
        this.input = new Input();
        this.output = new Output();
        this.computer = new Computer();
    }

    public void play() {

        boolean gameFirstStarted = true;

        while (true) {
            if (gameFirstStarted) {
                output.printGameStart();
                gameFirstStarted = false;
            }

            computer.pickSecretNumbers();

            while (true) {
                List<Integer> guessNumbers = input.readGuessNumbers();
                Map<String, Integer> result = computer.countStrikesAndBalls(guessNumbers);

                if (output.printResultAndContinue(result)) {
                    break;
                }
            }

            int retryChoice = input.readRetryChoice();
            if (retryChoice == 2)
                break;
        }
    }

}
