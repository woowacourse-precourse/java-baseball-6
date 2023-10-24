package baseball.controller;

import baseball.service.GameService;


public class GameController {
    public static void playBaseball() {
        GameService.startGame();
    }
}
