package baseball.error;
public class ErrorHandlerForInputBalls implements ErrorHandler {
    @Override
    public boolean checkString(String numberString){
        try{
            new CheckerForLengthOfInputBalls().check(numberString);
            new CheckerForValidIntegerInputOfInputBalls().check(numberString);
            new CheckerForRangeOfInputBalls().check(numberString);
            new CheckerForDuplicationOfInputBalls().check(numberString);
        }
        catch (IllegalArgumentException illegalArgumentException){
            throw illegalArgumentException;
        }
        return true;
    }
}
