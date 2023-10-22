package baseball.vo;

import baseball.model.Game;
import baseball.model.Result;

public class Round {
    private final Result result;

    public Round(Game game, Numbers user){
        result=game.calculateResult(user);
    }

    public String getResultMessage(){
        return result.getResult();
    }

    public boolean isFinishGame(){
        return result.isThreeStrike();
    }

}
