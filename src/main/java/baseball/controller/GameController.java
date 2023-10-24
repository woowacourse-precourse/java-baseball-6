package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.service.BaseballService;
import baseball.view.BaseballGameConsole;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private final int SIZE =3;
    private final int RESTART =1;
    private final int Terminate =2;

    BaseballService gameService;

    public void run() throws IllegalArgumentException {
        gameService = new BaseballService(SIZE);
        gameService.playGame();
        endGame();
        retry();
    }
    private void endGame() {
        BaseballGameConsole.printGameOverMessage();
    }
    private void retry() throws IllegalArgumentException {
        BaseballGameConsole.printRetryMessage();
        if (parseIntInput(Console.readLine()) == RESTART) {
            run();
        }
    }
    private int parseIntInput(String input) throws IllegalArgumentException {
        int inputNum = Integer.parseInt(Console.readLine());
        if (inputNum == RESTART || inputNum ==Terminate){return inputNum;}
        else{
            throw new IllegalArgumentException();
        }
    }
}
