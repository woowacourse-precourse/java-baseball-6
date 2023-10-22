package baseball.service;

import baseball.model.Game;
import baseball.vo.GameCycle;
import baseball.vo.Numbers;
import baseball.vo.Restart;

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
