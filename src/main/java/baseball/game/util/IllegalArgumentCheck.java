package baseball.game.util;

import static baseball.AppConfig.DIGIT_NUM;
import static baseball.AppConfig.MAX_CHAR;
import static baseball.AppConfig.MIN_CHAR;

public class IllegalArgumentCheck {
    public void checkArgument(String inputData){
        //Length Check
        if(inputData.length() != DIGIT_NUM){
            throw new IllegalArgumentException();
        }
        for(int i = 0 ; i < DIGIT_NUM ; i++){
            if(!(inputData.charAt(i) >= MIN_CHAR && inputData.charAt(i) <= MAX_CHAR)){
                throw new IllegalArgumentException();
            }
        }
    }
}
