package baseball.service;

import baseball.model.Game;
import baseball.vo.Numbers;
import baseball.vo.Restart;

public class GameService {
    private Game game;

    public String playRound(Numbers user){
        createGameIfNotPlaying();
        return game.playRound(user);
    }

    private void createGameIfNotPlaying(){
        if(game==null) {
            game = new Game();
        }
    }

    public boolean isRestart(Restart restart){
        return restart.isContinue();
    }

    public boolean isFinishGame(){
        if(game==null){
            throw new IllegalArgumentException("game이 진행되지 않았습니다.");
        }

        if(game.isFinishGame()){
            finishGame();
            return true;
        }
        return false;
    }

    private void finishGame(){
        game=null;
    }
}
