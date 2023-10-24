package baseball.error;
public class CheckerForLengthOfInputBalls {
    private Integer MAX_CAPACITY = 3;
    public void check(String numberString){
        if (numberString.length() != MAX_CAPACITY){
            throw new IllegalArgumentException();
        }
    }
}
