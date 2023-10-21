package baseball.domain;

public class GameCycle {
    private Result result;

    public GameCycle(Game game,Numbers user){
        this.result=game.calculateResult(user);
    }

    public String getResultMessage(){
        return result.getResult();
    }

    public boolean isFinish(){
        return result.isThreeStrike();
    }

}
