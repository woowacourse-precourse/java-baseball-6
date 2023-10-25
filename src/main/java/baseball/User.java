package baseball;

import camp.nextstep.edu.missionutils.Console;
import errorHandle.ErrorHandle;
import java.util.ArrayList;
import java.util.List;


public class User {
    final int userFixLength = 3;
    private List<Integer> user = new ArrayList<>();

    ErrorHandle error = new ErrorHandle();

    public void setUser() throws IllegalArgumentException {
        String userInput = Console.readLine();
        error.checkLengthInput(userInput);
        error.checkSameInput(userInput);

        for (int index = 0; index < userFixLength; index++) {
            user.add(Integer.parseInt(String.valueOf(userInput.charAt(index))));
        }

    }

    List<Integer> getUser() {
        return user;
    }

    public void clearUser() {
        user.clear();
    }


}
