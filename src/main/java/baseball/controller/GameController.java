package baseball.controller;

import baseball.config.Config;
import baseball.service.GameService;
import baseball.view.ErrorView;
import baseball.view.PrintView;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    PrintView printView = new PrintView();
    ErrorView errorView = new ErrorView();
    Config config = new Config();
    GameService gameService = new GameService(config);
    public void run() {
        setupGame();
        play();
        restartGame();
    }
    // 게임 시작전 세팅하는 함수
    public void setupGame() {
        gameService.init();
    }
    // 게임을 시작한다.
    public void play() {
        gameService.startGame();
    }

    // 게임 재시작 여부를 묻고 재시작 또는 종료 시킨다.
    public void restartGame() {
        printView.printRestartMessage();
        String mode = gameService.restart();
        if (mode.equals("RESTART")) {
            run();
        }else if(mode.equals("END")) {
            printView.printRestartEndMessage();
        }else {
            errorView.validateInputModeError();
        }
    }
}
