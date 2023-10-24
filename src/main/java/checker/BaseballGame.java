package checker;

import ball.Balls;
import console.InputView;
import console.OutputView;
import judge.Judge;
import numer_generator.NumberGenerator;

public class BaseballGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Judge judge = new Judge();

    public void game() {
        outputView.gameStart();
        boolean playAgain = true;

        while (playAgain) {
            playGame();
            outputView.userCorrect();
            playAgain = inputView.isContinuable();
        }
    }

    private void playGame() {
        String computersNumber = NumberGenerator.getComputersNumber();
        boolean correct = false;

        while (!correct) {
            outputView.inputNumber();
            String userInput = inputView.getUserInput();
            Balls userBalls = new Balls(userInput);
            Balls computerBalls = new Balls(computersNumber);
            judge.compareBalls(userBalls, computerBalls);
            outputView.checkCount(judge.getStrikeCount(), judge.getBallCount());
            correct = judge.isCorrect();
        }
    }
}
