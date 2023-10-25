package baseball.control;

import baseball.inputProcess.UserInput;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UserControl {
    private final String inputNumber;

    public UserControl(String inputNumber) {
        verify(inputNumber);
        this.inputNumber = inputNumber;
    }

    public String decideUserNumber() {
        return inputNumber;
    }
    public void isDuplicated(String num) {
        ArrayList<String> strList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            strList.add(String.valueOf(num.charAt(i)));
        }
        Set<String> strSet = new HashSet<>(strList);
        if (strList.size() != strSet.size()) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    public void isNotFull(String num) {
        if (num.length() != 3) {
            throw new IllegalArgumentException("3자리의 숫자가 아닙니다.");
        }
    }

    public void isIncludeZero(String num) {
        for (int i = 0; i < 3; i++) {
            if (num.charAt(i) == '0') {
                throw new IllegalArgumentException("0이 포함되어 있습니다.");
            }
        }
    }

    public void isNumber(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (!Character.isDigit(num.charAt(i))) {
                throw new IllegalArgumentException("숫자가 아닙니다.");
            }
        }
    }

    public void verify(String inputValue) {
        isNumber(inputValue);
        isNotFull(inputValue);
        isDuplicated(inputValue);
        isIncludeZero(inputValue);
    }
}
