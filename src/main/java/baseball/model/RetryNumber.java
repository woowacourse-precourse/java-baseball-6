package baseball.model;
import baseball.view.GameView;
public class RetryNumber {
    private String retryNumber;

    public String getRetryNumber(){
        return retryNumber;
    }

    public RetryNumber(String retryNumber){
        isCorrectRetryNumber(retryNumber);
        this.retryNumber=retryNumber;
    }

    public static void isCorrectRetryNumber(String number){
        if(!number.equals("1")&&!number.equals("2")){
            throw new IllegalArgumentException();
        }
    }
}