package baseball.controller;

import baseball.service.GameService;

public class GameController {
    private final GameService gameService;

    // GameController 생성시 GameService 를 같이 생성.
    public GameController() {
        this.gameService = new GameService();
    }

    // 숫자 야구 게임 시작 메서드.
    public void start() {
        gameService.start();
    }
}