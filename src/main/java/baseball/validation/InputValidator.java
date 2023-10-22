package baseball.validation;

import static baseball.common.Constants.NUMBER_LENGTH;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public boolean isValidLength(String userNum) {
        if (userNum.length() != NUMBER_LENGTH) {
            return false;
        }
        return true;
    }

    public boolean isValidNumber(String userNum) {
        char[] charUserNum = userNum.toCharArray();
        Set<Character> userNumSet = new HashSet<>();

        //0이 없는 숫자냐?
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            char chUserNum = charUserNum[i];
            //숫자냐?
            if (!Character.isDigit(chUserNum)) {
                return false;
            } else if (chUserNum == '0') { // 0이냐?
                return false;
            }
            userNumSet.add(chUserNum);
        }
        //중복된 숫자
        if (userNumSet.size() != NUMBER_LENGTH) {
            return false;
        }
        return true;
    }

}
