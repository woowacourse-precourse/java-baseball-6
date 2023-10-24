package baseball.controller;

import baseball.service.GameService;

public class GameController {
    GameService gameService = new GameService();

    public void run(){
        boolean retry = true;

        while(retry){
            gameService.setGame();
            gameService.startGame();
            gameService.stopGame();

            if(!gameService.retryGame()){
                retry = false;
            }
        }
    }
}
