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

}
