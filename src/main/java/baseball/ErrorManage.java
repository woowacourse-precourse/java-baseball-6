package baseball;

import baseball.message.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ErrorManage {

    public void checkNumberLength(String userNumber) {
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_NOT_3.getMessage());
        }
    }

    public void checkDuplicate(List<Integer> userNumberList) {
        int length = userNumberList.size();
        Set<Integer> userNumberSet = new HashSet<>(userNumberList);

        if (length != userNumberSet.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    public void checkIsNumber(String userNumber) {
        String[] userInput = userNumber.split("");
        for (int i = 0; i < userNumber.length(); i++) {
            try {
                Integer.parseInt(userInput[i]);
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.NOT_NUMBER.getMessage());
            }
        }
    }

    public void checkNumberRange(List<Integer> userNumberList) {
        for (Integer num : userNumberList) {
            if (isRange(num)) {
                throw new IllegalArgumentException(ErrorMessage.NOT_RANGE_NUMBER.getMessage());
            }
        }
    }

    private boolean isRange(int num) {
        return num < 1 || num > 9;
    }

    public static void wrongGameFlag(int gameFlag) {
        if (gameFlag != 1 && gameFlag != 2) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_GAMEFLAG.getMessage());
        }
    }
}
