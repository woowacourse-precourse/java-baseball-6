package baseball.Model;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public String getUserNum() {
        return Console.readLine();
    }

    public void handleException(String userNum) {
        if (userNum.length() != 3) {
            throw new IllegalArgumentException();
        }
        try {
            Integer.parseInt(userNum);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        for (int userNumIndex = 0; userNumIndex < 2; userNumIndex++) {
            if (userNum.charAt(userNumIndex) == userNum.charAt(2)) {
                throw new IllegalArgumentException();
            }
            if (userNumIndex == 1 && userNum.charAt(userNumIndex) == userNum.charAt(0)) {
                throw new IllegalArgumentException();
            }
        }
    }

}
