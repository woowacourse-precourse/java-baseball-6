package baseball.service;

import baseball.utils.checkExceptionUser;
import baseball.view.userView;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class service {
    checkExceptionUser check = new checkExceptionUser();
    userView userView = new userView();

    public List<Integer> userInput() throws IllegalArgumentException {
        String userInput = Console.readLine();
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

    public boolean playAgain() {
        userView.userRegameMessage();
        String userregameNum = Console.readLine();
        int userRegameNum = Integer.parseInt(userregameNum);
        check.checkUserRegameException(userRegameNum);

        if (userRegameNum == 1) {
            return true;
        }
        return false;
    }
}
