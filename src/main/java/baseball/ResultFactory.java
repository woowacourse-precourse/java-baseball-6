package baseball;

import java.util.List;

public class ResultFactory {
    public Result getResult(List<Hint> hints){
        int numOfBalls = 0;
        int numOfStrikes = 0;
        for(Hint hint : hints){
            if (hint == Hint.BALL){
                numOfBalls++;
            }
            if (hint == Hint.STRIKE){
                numOfStrikes++;
            }
        }
        return new Result(numOfBalls, numOfStrikes);
    }
}

