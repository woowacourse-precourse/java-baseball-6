package baseball.service;

import baseball.utils.checkExceptionUser;
import baseball.view.userView;
import java.util.ArrayList;
import java.util.List;

public class service {
    checkExceptionUser check = new checkExceptionUser();
    userView userView = new userView();

    public List<Integer> userInput() {
        String userInput = userView.userInputMessage();
        ArrayList<Integer> userNumArray = new ArrayList<>();

        //String userNumber = String.valueOf(userInput);

        for (int i = 0; i < userInput.length(); i++) {
            char userNum = userInput.charAt(i);
            int userIntNum = Character.getNumericValue(userNum);
            userNumArray.add(userIntNum);
        }
        check.checkUserInputSizeException(userNumArray);
        return userNumArray;
    }

    // judgeView 부분에 심판의 역할을 분리

    public int[] judgeBaseball(String computer, List<Integer> user) {
        int strike = 0;
        int ball = 0;
        ArrayList<Integer> computerNum = new ArrayList<>();

        for (char com : computer.toCharArray()) {
            computerNum.add(Character.getNumericValue(com));
        }

        for (int i = 0; i < computerNum.size(); i++) {
            for (int j = 0; j < user.size(); j++) {
                if (computerNum.get(j) == user.get(j) && i == j) {
                    strike++;
                }
                if (computerNum.get(i) == user.get(j) && i != j) {
                    ball++;
                }
            }
        }
        return new int[]{strike, ball};
    }
}
