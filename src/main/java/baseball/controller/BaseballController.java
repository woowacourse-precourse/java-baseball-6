package baseball.controller;

import baseball.exception.InvalidInputException;
import baseball.service.BaseballService;
import baseball.view.ConsoleInput;
import baseball.view.ConsoleOutput;

import java.util.List;

public class BaseballController {

    private BaseballService service;
    private static final int RESTART_GAME = 1;

    public BaseballController(BaseballService service) {
        this.service = service;
    }

    /**
     * 초기 게임 세팅
     */
    public void init() {
        ConsoleOutput.init();
    }

    /**
     * 게임 시작
     */
    public void startGame() throws InvalidInputException {
        List<Integer> user;
        do {
            service.setNewGame();
            while (true) {
                ConsoleOutput.requestInput();
                user = ConsoleInput.readDigitNumber(3);

                if (service.checkVictory(user)) {
                    ConsoleOutput.displayVictory();
                    break;
                }
                ConsoleOutput.displayHint(service.getHint(user));
            }
        } while (askRestartGame());
    }


    /**
     * 재시작 여부
     */
    private boolean askRestartGame() throws InvalidInputException {
        ConsoleOutput.requestRestart();
        return ConsoleInput.readDigitNumber(1).get(0) == RESTART_GAME;
    }
}
