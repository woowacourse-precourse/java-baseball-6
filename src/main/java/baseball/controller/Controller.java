package baseball.controller;

import baseball.service.Service;
import baseball.view.InputView;
import baseball.view.OutputView;

import camp.nextstep.edu.missionutils.Console;

public class Controller {
    Service service = new Service();
    public void run() {
        boolean isFinished = false;
        OutputView.gameStartMessage();
        while(!isFinished) {
            service.setGame();
            startGame();
            isFinished = finishGame();
        }
    }

    private void startGame() {
        boolean isCorrect = false;
        while(!isCorrect) {
            isCorrect = playGame();
        }
        OutputView.gameFinishedMessage();
    }

    private boolean playGame() {
        InputView.inputNumberMessage();
        String input = Console.readLine();
        String result = service.playGame(input);
        OutputView.gameResultMessage(result);
        return result.equals("3스트라이크");
    }

    private boolean finishGame() {
        InputView.restartGameMessage();
        String input = Console.readLine();
        return service.finishGame(input);
    }
}
