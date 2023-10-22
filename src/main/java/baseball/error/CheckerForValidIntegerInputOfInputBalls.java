package baseball.error;

import java.util.Arrays;

public class CheckerForValidIntegerInputOfInputBalls {
    public void check(String numberString){
        try{
            Integer.parseInt(numberString);
        }
        catch (Exception e){
            throw new IllegalArgumentException();
        }

    }
}
