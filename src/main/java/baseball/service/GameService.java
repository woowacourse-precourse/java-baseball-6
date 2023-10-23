package baseball.service;

import baseball.BaseBallGame;

public class GameService {
    private final BaseBallGame baseBallGame = new BaseBallGame();
    public void play(){
        while(true){
            String result = baseBallGame.start();
            if(result.equals("게임 종료")) break;
        }
    }
}
