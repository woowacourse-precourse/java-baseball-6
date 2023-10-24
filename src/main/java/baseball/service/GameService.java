package baseball.service;

import baseball.dto.RoundResult;
import baseball.model.Game;
import baseball.vo.Numbers;
import baseball.vo.Restart;

public class GameService {
    private Game game;

    public RoundResult playRound(Numbers user){
        createGameIfNotPlaying();
        RoundResult roundResult=game.playRound(user);

        if(roundResult.isFinish()){
            game=null;
        }

        return roundResult;
    }

    private void createGameIfNotPlaying(){
        if(game==null) {
            game = new Game();
        }
    }

    public boolean isRestart(Restart restart){
        return restart.isContinue();
    }
}
