package baseball.controller;

import baseball.domain.Result;
import baseball.service.GameService;
import baseball.view.InputConsole;
import baseball.view.OutputConsole;
import baseball.domain.ComputerNumber;

import static baseball.domain.Message.*;
import static baseball.domain.Result.*;

public class BaseballGame {

    private static final int RESTART_NUMBER = 1;
    private final ComputerNumber COMPUTER_NUMBER = ComputerNumber.getInstance();
    private Result result = INIT;
    private final GameService gameService;

    public BaseballGame(GameService gameService) {
        COMPUTER_NUMBER.createNumberList();
        OutputConsole.println(START.getMessage());
        this.gameService = gameService;
    }

    public void start() {
        while (result == WRONG || result == INIT) {
            result = gameService.checkResult(COMPUTER_NUMBER.getNumberList(), InputConsole.readGameNumberList());
            if (result == CORRECT && !isRestart()) {
                break;
            }
        }
    }

    private boolean isRestart() {
        int endOrStartNumber = InputConsole.readEndOrStartNumber();
        if (endOrStartNumber == RESTART_NUMBER) {
            result = INIT;
            COMPUTER_NUMBER.createNumberList();
            return true;
        }

        return false;
    }

}
