package baseball.service;

import baseball.model.Game;
import baseball.model.GameCycle;
import baseball.model.Numbers;
import baseball.model.Restart;

public class GameService {
    private Game game;

    public GameCycle play(Numbers user){
        initialize();
        return new GameCycle(game,user);
    }

    private void initialize(){
        if(game==null) {
            game = new Game();
        }
    }

    public boolean isRestart(Restart restart){
        return restart.isContinue();
    }

    public void finishGame(){
        game=null;
    }
}
