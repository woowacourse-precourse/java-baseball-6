package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    private String userNum;

    void inputNum() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        userNum = readLine();
        if (userInputError()) {
            throw new IllegalArgumentException();
        }
    }

    boolean userInputError() {
        if (userNum.length() != 3) {
            return (true);
        }
        if (checkNumberDuplicated()) {
            return (true);
        }
        for (int i = 0; i < 3; i++) {
            if (!checkNumberRange(userNum.charAt(i))) {
                return (true);
            }
        }
        return (false);
    }

    boolean checkNumberRange(char c) {
        if (c >= '1' && c <= '9') {
            return (true);
        }
        return (false);
    }

    boolean checkNumberDuplicated() {
        if (userNum.charAt(0) == userNum.charAt(1) ||
                userNum.charAt(0) == userNum.charAt(2)
                || userNum.charAt(1) == userNum.charAt(2)) {
            return (true);
        }
        return (false);
    }

    static boolean chooseRestart() throws IllegalArgumentException {
        String userNum;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        userNum = readLine();
        if (userNum.length() != 1 || (userNum.charAt(0) != '1' && userNum.charAt(0) != '2')) {
            throw new IllegalArgumentException();
        }
        return (userNum.charAt(0) == '1');
    }

    String getUserNum() {
        if (userNum == null) {
            return (null);
        }
        return (userNum);
    }
}
