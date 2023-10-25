package baseball.user;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private String userNumber;

    public User() {
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void inputUserNumber() {
        // 사용자에게 3자리 숫자 입력받기
        UserNumber userNumber = new UserNumber(Console.readLine());

        this.userNumber = userNumber.getUserNumber();
    }
}