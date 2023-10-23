package baseball.vo;

import baseball.model.Result;

public class Round {
    private final Result result;

    public Round(Numbers computer,Numbers user){
        result=new Result(computer,user);
    }

    public String getResultMessage(){
        return result.getResult();
    }

    public boolean isFinishGame(){
        return result.isThreeStrike();
    }

}
