package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    private String userNum;

    void inputNum() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        userNum = readLine();
        if (userNum.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    String getUserNum() {
        if (userNum == null) {
            return (null);
        }
        return (userNum);
    }
}
