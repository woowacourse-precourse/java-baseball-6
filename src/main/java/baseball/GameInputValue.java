package baseball;

import baseball.enums.ExceptionMessage;
import baseball.exception.WrongInputException;

import java.util.HashSet;

public class GameInputValue {
    private String userInputValue;
    private final String computerValue;

    public GameInputValue(String computerValue) {
        this.computerValue = computerValue;
        this.userInputValue = "";
    }

    public String getUserInputValue() {
        return userInputValue;
    }

    public String getComputerValue() {
        return computerValue;
    }

    // TODO 조금 더 명확한 목적을 띄는 메서드 ...
    public void setUserInputValue(String userInputValue) {
        this.userInputValue = userInputValue;
        checkValidUserInput();
    }

    public boolean isEqaulsUserAndComputerValue() {
        return this.userInputValue.equals(this.computerValue);
    }

    public int countSameNumber() {
        int count = 0;
        for (char c : this.userInputValue.toCharArray()) {
            if (this.computerValue.contains(String.valueOf(c))) {
                count++;
            }
        }
        return count;
    }

    public int countSamePositionAndNumber(){
        int count = 0;
        char[] computerValueCharArr = computerValue.toCharArray();
        char[] userVauleCharArr = userInputValue.toCharArray();
        for (int i = 0; i < computerValueCharArr.length; i++) {
            if (computerValueCharArr[i] == userVauleCharArr[i]) {
                count++;
            }
        }
        return count;
    }

    public boolean isDuplicationNumberInUserInputValue() {
        HashSet<Character> set = new HashSet<>();
        for (char c : this.userInputValue.toCharArray()) {
            set.add(c);
        }
        return set.size() != 3;
    }

    public boolean isNothing() {
        return countSameNumber() == 0;
    }


    public void checkValidUserInput() {
        if (!isThreeDigits()) {
            throw new WrongInputException(ExceptionMessage.WRONG_INPUT_NOT_THREE_DIGITS.getMessage());
        }

        if (!isNumber()){
            throw new WrongInputException(ExceptionMessage.WRONG_INPUT_NOT_NUMBER.getMessage());
        }

        if(isDuplicationNumberInUserInputValue()){
            throw new WrongInputException(ExceptionMessage.WRONG_INPUT_DUPLICATE_VALUE.getMessage());
        }
    }


    private boolean isThreeDigits() {
        return userInputValue.length() == 3;
    }

    private boolean isNumber() {
        return userInputValue != null && userInputValue.matches("[-+]?\\d*\\.?\\d+");
    }

}
