package baseball.Controller;

import baseball.service.Service;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class BaseballGame {
    Service service = new Service();

    public void start() {
        boolean isRestartGame = true;
        OutputView.printBaseballGameStart();
        while (isRestartGame) {
            setComputerGame();
            startPlayerGame();
            isRestartGame = restartGame();
        }
    }

    private void setComputerGame() {
        service.setComputerGame();
    }

    private void startPlayerGame() {
        boolean isCorrectAllAnswer = false;
        while(!isCorrectAllAnswer) {
            isCorrectAllAnswer = playGame();
        }
        OutputView.printAllCorrectAnswer();
    }

    private boolean playGame() {
        InputView.printPlayerNumber();
        String playerNumbers = Console.readLine();
        String result = service.playGame(playerNumbers);
        OutputView.printResult(result);
        return Objects.equals(result, "3스트라이크");
    }

    private boolean restartGame() {
        InputView.printRestartGame();
        String playerInput = Console.readLine();
        return service.restartGame(playerInput);
    }

}

