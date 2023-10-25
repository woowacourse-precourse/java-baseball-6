package baseball.service;

import baseball.global.config.BaseballGameConstant;

import java.util.HashSet;
import java.util.Set;

public class InputErrorCheckService {

    public InputErrorCheckService(){}

    public Boolean IntegerCheck(String userInputNum){

        for (char c : userInputNum.toCharArray()) {
            if (!Character.isDigit(c)) return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    public Boolean sameNumCheck(String userInputNum){
        Set<Character> charSet = new HashSet<>();
        for (char c : userInputNum.toCharArray()) {
            charSet.add(c);
        }
        return charSet.size() == BaseballGameConstant.BASEBALL_NUM_SIZE;
    }

    //input이 3이어야하며, 숫자로만 이루어지고, 같은수가 없어야한다
    public Boolean errorCheck(String userInputNum){
        return (inputNumLengthCheck(userInputNum)
                && IntegerCheck(userInputNum)
                && sameNumCheck(userInputNum));
    }

    public boolean inputNumLengthCheck(String userInputNum) {
        return userInputNum.length() == BaseballGameConstant.BASEBALL_NUM_SIZE;
    }

    //1과 2만 받는다
    public Boolean restartInputErrCheck(String restartInput) {
        return ((restartInput.equals("1") || restartInput.equals("2")));
    }

}
