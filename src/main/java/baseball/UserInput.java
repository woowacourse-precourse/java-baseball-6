package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {

    public String readUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        return userInput;
    }

    public void checkUserInput(String userInput) {
        try {
            checkIfIncludesZero(userInput);
            int userNum = checkIfInteger(userInput);
            checkIfValidRange(userNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public int checkIfInteger(String userInput) throws NumberFormatException {
        return Integer.parseInt(userInput);
    }

    public void checkIfValidRange(int userNum) throws NumberFormatException {
        if (0 > userNum || userNum > 999) {
            throw new NumberFormatException();
        }
    }

    public void checkIfIncludesZero(String userInput) throws NumberFormatException {
        if (userInput.indexOf('0') != -1) {
            throw new NumberFormatException();
        }
    }

    public List<Integer> stringToList(String userInput) {
        List<Integer> userNums = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            char c = userInput.charAt(i);
            userNums.add(c - '0');
        }
        return userNums;
    }
}
