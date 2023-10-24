package baseball.error;
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
