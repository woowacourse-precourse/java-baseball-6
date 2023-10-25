package baseball;

import baseball.domain.Computer;
import baseball.domain.GameStatus;
import baseball.domain.Judge;
import baseball.domain.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class Application {
    private static final int CONTINUE = 1;

    public static void main(String[] args) {
        int statusCode = CONTINUE;

        Player player = new Player();
        Computer computer = new Computer();
        Judge judge = new Judge();
        GameStatus gameStatus = new GameStatus();

        OutputView.printGameStartMessage();

        while (statusCode == CONTINUE) {
            boolean isWin = false;
            List<Integer> computerNumbers = computer.generateRandomNumbers();
            while (!isWin) {
                player.inputNumbers();
                List<Integer> inputNumbers = player.getNumbers();
                isWin = judge.judgeGameResult(computerNumbers, inputNumbers);
            }

            OutputView.printGameDoneMessage();
            InputView.printRetryMessage();
            gameStatus.inputStatusCode();
            statusCode = gameStatus.getGameState();;
        }
    }
}