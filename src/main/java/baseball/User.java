package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    String userNum;

    void inputNum() throws IllegalArgumentException {
        userNum = readLine();
        if (userNum.length() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
