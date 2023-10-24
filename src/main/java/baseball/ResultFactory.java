package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResultFactory {
    public Result compareAndGetResult(UserPrediction userPrediction, Answer answer){
        List<Hint> hints = new ArrayList<>();
        hints.add(getHint(answer, userPrediction.getFirstNumber(), Order.FIRST));
        hints.add(getHint(answer, userPrediction.getSecondNumber(), Order.SECOND));
        hints.add(getHint(answer, userPrediction.getThirdNumber(), Order.THIRD));
        return getResult(hints);
    }

    private Hint getHint(Answer answer, Integer number, Order order){
        if (order == Order.FIRST){
            if (answer.getFirstNumber() == number){
                return Hint.STRIKE;
            }
            if (answer.getSecondNumber() == number || answer.getThirdNumber() == number){
                return Hint.BALL;
            }
            return Hint.NOTHING;
        }
        if (order == Order.SECOND){
            if (answer.getSecondNumber() == number){
                return Hint.STRIKE;
            }
            if (answer.getFirstNumber() == number || answer.getThirdNumber() == number){
                return Hint.BALL;
            }
            return Hint.NOTHING;
        }
        if (order == Order.THIRD){
            if (answer.getThirdNumber() == number){
                return Hint.STRIKE;
            }
            if (answer.getFirstNumber() == number || answer.getSecondNumber() == number){
                return Hint.BALL;
            }
            return Hint.NOTHING;
        }
        return Hint.NOTHING;
    }

    private Result getResult(List<Hint> hints){
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

