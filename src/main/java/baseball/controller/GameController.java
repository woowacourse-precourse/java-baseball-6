package baseball.controller;

import baseball.config.Config;
import baseball.service.GameService;
import baseball.view.PrintView;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    PrintView printView = new PrintView();

   private final GameService gameService = new GameService();

    public void run() {
        setupGame();
        play();
        gameRestart();
    }
    // 게임 시작전 세팅하는 함수
    public void setupGame() {
        gameService.gameSet();
    }
    // 게임을 시작한다.
    public void play() {
        gameService.startGame();
    }

    // 게임 재시작 여부를 묻고 재시작 또는 종료 시킨다.
    public void gameRestart() {
        printView.printRestartMessage();
        int mode = Integer.parseInt(Console.readLine());
        if (mode == 1) {
            run();
        }else if(mode == 2) {
            printView.printRestartEndMessage();
        }
    }
}
