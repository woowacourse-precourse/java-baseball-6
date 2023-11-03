package baseball;

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

    public void setUserInputValue(String userInputValue) {
        this.userInputValue = userInputValue;
    }

    public boolean isEqaulsUserAndComputerValue() {
        return this.userInputValue.equals(this.computerValue);
    }

    public int countSameNumber() {
        if (isDuplicationNumberInUserInputValue()) {
            // TODO 그에 맞는 예외처리 생각하기
            throw new IllegalArgumentException();
        }
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
}
