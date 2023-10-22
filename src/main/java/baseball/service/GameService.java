package baseball.service;

import baseball.model.Game;
import baseball.vo.Round;
import baseball.vo.Numbers;
import baseball.vo.Restart;

public class GameService {
    private Game game;

    public Round playRound(Numbers user){
        createGameIfNotPlaying();
        return new Round(game,user);
    }

    private void createGameIfNotPlaying(){
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
