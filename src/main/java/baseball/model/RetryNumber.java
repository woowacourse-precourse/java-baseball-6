package baseball.model;

import static constant.MessageList.END;
import static constant.MessageList.RESTART;

public class RetryNumber {
    private String retryNumber;
    public RetryNumber(String playerInput){
        if (validateNumber(playerInput)){
            this.retryNumber = playerInput;
        }
    }
    public String getRetryNumber(){
        return retryNumber;
    }
    public boolean validateNumber(String playerInput){
        if (playerInput.equals(RESTART) || playerInput.equals(END)){
            return true;
        }
        throw new IllegalArgumentException();
    }
}
