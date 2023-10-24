package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {

    public void run() {
        OutputView.printStartMessage();
        playGame();
    }

    private void playGame() {
        playRounds(createAnswerBalls());
        endGame();
    }

    private void playRounds(Balls answer) {
        Balls playerBalls = getPlayerBalls();
        RoundResult roundResult = playerBalls.compareWith(answer);
        OutputView.print(roundResult);
        if (roundResult.isGameEnd()) {
            return;
        }
        playRounds(answer);
    }

    private void endGame() {
        if (InputView.retryOrExit()) {
            playGame();
        }
    }

    private Balls createAnswerBalls() {
        List<Integer> numbers = RandomNumberGenerator.generate();
        return Balls.of(numbers);
    }

    private Balls getPlayerBalls() {
        List<Integer> numbers = InputView.getNumbers();
        return Balls.of(numbers);
    }
}