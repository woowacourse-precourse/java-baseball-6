package baseball;

import baseball.service.GameService;

public class GameController {
    private final GameService gameService = new GameService();
    public void play(){
        while(true){
            String result = gameService.start();
            if(result.equals("게임 종료")) break;
        }
    }
}
