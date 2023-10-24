package baseball.validation;

import static baseball.common.Constants.NUMBER_LENGTH;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    //길이가 3인가?
    public boolean isValidLength(String userNum) {
        if (userNum.length() != NUMBER_LENGTH) {
            return false;
        }
        return true;
    }

    public boolean isValidNumber(String userNum) {
        char[] charUserNum = userNum.toCharArray();
        Set<Character> userNumSet = new HashSet<>();

        //0을 포함하지 않는 숫자로만 입력받기
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            char chUserNum = charUserNum[i];

            if (!Character.isDigit(chUserNum)) { //숫자인가?
                return false;
            } else if (chUserNum == '0') { // 0인가?
                return false;
            }
            userNumSet.add(chUserNum);
        }
        //중복된 숫자인가?
        if (userNumSet.size() != NUMBER_LENGTH) {
            return false;
        }
        
        return true;
    }

}
