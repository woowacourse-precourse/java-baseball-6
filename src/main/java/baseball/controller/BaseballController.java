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
        do {
            service.setNewGame();
            playSingleRound();
        } while (askRestartGame());
    }

    /**
     * 야구 한 게임 진행
     */
    private void playSingleRound() {
        List<Integer> user;

        while (!service.checkVictory(user = askUserNumber())) {
            ConsoleOutput.displayHint(service.getHint(user));
        }
        ConsoleOutput.displayVictory();
    }

    /**
     * 숫자 입력
     */
    private List<Integer> askUserNumber() throws InvalidInputException {
        ConsoleOutput.requestInput();
        return ConsoleInput.readDigitNumber(3);
    }


    /**
     * 재시작 여부 입력
     */
    private boolean askRestartGame() throws InvalidInputException {
        ConsoleOutput.requestRestart();
        return ConsoleInput.readDigitNumber(1).get(0) == RESTART_GAME;
    }
}
