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
        //문자열의 길이가 맞지 않을 경우
        if(inputData.length() != DIGIT_NUM){
            throw new IllegalArgumentException();
        }
    }

    public void checkArgumentWrongChar(String inputData){
        //문자열의 i번째 문자가 허용된 문자의 범위가 아닐경우
        for(int i = 0 ; i < DIGIT_NUM ; i++){
            if(!(inputData.charAt(i) >= MIN_CHAR && inputData.charAt(i) <= MAX_CHAR)){
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkArgumentWrongAnswer(String inputAnswer){
        //사용자의 답변의 길이가 1이 아닐경우
        if(inputAnswer.length() != 1){
            throw new IllegalArgumentException();
        }
        //사용자의 답변이 허용된 문자가 아닐경우
        if(inputAnswer.charAt(0) != '1' && inputAnswer.charAt(0) != '2' ){
            throw new IllegalArgumentException();
        }
    }
}
