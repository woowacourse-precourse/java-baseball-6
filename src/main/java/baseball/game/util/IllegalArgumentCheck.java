package baseball.game.util;

import static baseball.AppConfig.DIGIT_NUM;
import static baseball.AppConfig.MAX_CHAR;
import static baseball.AppConfig.MIN_CHAR;

public class IllegalArgumentCheck {
    public void checkArgument(String inputData){
        checkArgumentLength(inputData);
        checkArgumentWrongChar(inputData);
    }

    public void checkArgumentLength(String inputData){
        if(inputData.length() != DIGIT_NUM){
            throw new IllegalArgumentException();
        }
    }

    public void checkArgumentWrongChar(String inputData){
        for(int i = 0 ; i < DIGIT_NUM ; i++){
            if(!(inputData.charAt(i) >= MIN_CHAR && inputData.charAt(i) <= MAX_CHAR)){
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkArgumentWrongAnswer(String inputAnswer){
        if(inputAnswer.length() != 1){
            throw new IllegalArgumentException();
        }
        if(inputAnswer.charAt(0) != '1' && inputAnswer.charAt(0) != '2' ){
            throw new IllegalArgumentException();
        }
    }
}
