package baseball;

import baseball.constants.ExceptionConstants;
import baseball.constants.GameConstants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exceptions {

    //3개의 숫자 아닐시 오류
    public static void validateNumberLength (String userAnswer){
        if(!userAnswer.matches("^\\d{"+ GameConstants.MAX_NUMBER+"}$")){
            throw new IllegalArgumentException(ExceptionConstants.REQUEST_ONLY_3_NUMS);
        }
    }

    //중복된 숫자가 있을 시 오류
    public static void validateUniqueNumbers (String userAnswer) {
        if(Arrays.stream(userAnswer.split("")).distinct().count() != GameConstants.MAX_NUMBER){
            throw new IllegalArgumentException(ExceptionConstants.REQUEST_OTHER_3_NUMS);
        }
    }

    //재시작 질문에 1,2 아니면 오류
    public static void validateRestartInput (String userAnswerForRestart) {
        if(!(userAnswerForRestart.equals("1") || userAnswerForRestart.equals("2"))){
            throw new IllegalArgumentException(ExceptionConstants.REQUEST_1_OR_2);
        }
    }


}
