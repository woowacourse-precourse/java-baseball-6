package baseball.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.util.Constants;

public class User {
    private final BaseballNumber userNumber;

    public User() {
        this.userNumber = new BaseballNumber();
    }

    public void inputUserNumber() {
        System.out.print(Constants.INPUT_PROMPT);
        userNumber.setNumber(readLine());
    }

    public boolean wantToRestart() {
        System.out.print(Constants.RESTART_PROMPT);
        String input = readLine();
        if ("1".equals(input)) {
            return true;
        } else if ("2".equals(input)) {
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 입력값 입니다.");
        }
    }

    public BaseballNumber getUserNumber() {
        return userNumber;
    }
}