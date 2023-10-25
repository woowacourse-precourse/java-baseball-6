package baseball.user;

import camp.nextstep.edu.missionutils.Console;

public class User {

    private String userNumber;
    private UserStatus userStatus;

    public User() {
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void inputUserNumber() {
        UserNumber userNumber = new UserNumber(Console.readLine());
        this.userNumber = userNumber.getUserNumber();
    }

    public void inputUserStatus() {
        this.userStatus = new UserStatus(Console.readLine());
    }

    public String getUserStatus() {
        return this.userStatus.getStatus();
    }
}