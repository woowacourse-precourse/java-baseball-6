package baseball;

import baseball.service.GameService;

public class GameController {
    private final GameService gameService = new GameService();
    public void play(){
        while(true){
            if(!gameService.start()) break;
        }
    }
}
