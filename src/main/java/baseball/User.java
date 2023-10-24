package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String userInput;
    private List<Integer> userList;

    public User(String userInput) {
        setUserInput(userInput);
    }

    public List<Integer> getUserList() {
        return userList;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    // 검증이 완료된 사용자 입력에 대해서 List 타입으로 변환
    private void pickUserNumbers() {
        userList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            userList.add(userInput.charAt(i) - '0');
        }
    }

    public void checkUserInputError() {
        // 3자리가 아님 | Integer 타입이 아님 | 중복이 있음 판단
        if (UserInputCntError(userInput, 3) || IntegerError(userInput) || checkDuplication(userInput)) {
            throw new IllegalArgumentException();
        }
        pickUserNumbers();
    }

    public boolean UserInputCntError(String userInput, int cnt) {
        if (userInput.length() != cnt) {
            return true;
        } else {
            return false;
        }
    }

    public boolean IntegerError(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            int userInputToChar = userInput.charAt(i);
            if (userInputToChar - '0' < 0 || userInputToChar - '0' > 9) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDuplication(String userInput) {
        char firstChar = userInput.charAt(0);
        char middleChar = userInput.charAt(1);
        char lastChar = userInput.charAt(2);

        if (firstChar == middleChar || middleChar == lastChar || firstChar == lastChar) {
            return true;
        }
        return false;
    }

}
