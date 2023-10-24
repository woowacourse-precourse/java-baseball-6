package baseball.controller;

import baseball.service.GameService;

/* 게임을 컨트롤하는 객체 */
public class GameController {
    public GameService gameService = new GameService();

    /* 게임을 실행하는 메소드 */
    public void run() throws IllegalArgumentException {
            initGame();
            playGame();
            endGame();
    }

    /* 게임을 초기화하는 메소드 */
    public void initGame() {
        gameService.initGame();
    }

    /* 게임을 진행하는 메소드 */
    public void playGame() throws IllegalArgumentException{
        gameService.playGame();
    }

    public void endGame() {
        boolean isEnd = gameService.endGame();
        if(!isEnd) {
            run();
        }
    }
}
