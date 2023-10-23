package baseball.Controller;

import baseball.service.Service;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class BaseballGame {
    Service service = new Service();

    public void start() {
        boolean restartGame = true;
        OutputView.printBaseballGameStart();
        while (restartGame) {
            setComputerGame();
            startPlayerGame();
            restartGame = restartGame();
        }
    }

    private void setComputerGame() {
        service.setComputerGame();
    }

    private void startPlayerGame() {
        boolean correctAllAnswer = false;
        while(!correctAllAnswer) {
            correctAllAnswer = playGame();
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
        String player = Console.readLine();
        return service.restartGame(player);
    }

}

