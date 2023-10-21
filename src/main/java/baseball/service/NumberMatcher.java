package baseball.service;

import baseball.model.GameResult;
import java.util.List;

public class NumberMatcher {
    private static final int NUMBER_SIZE = 3;

    public GameResult match(List<Integer> userNumber, List<Integer> answerNumber){
        GameResult result = new GameResult();

        for(int i = 0; i < NUMBER_SIZE; i++){
            if(userNumber.get(i).equals(answerNumber.get(i))){
                result.incrementStrike();
            }else if(answerNumber.contains(userNumber.get(i))){
                result.incrementBall();
            }
        }

        return result;
    }

}
