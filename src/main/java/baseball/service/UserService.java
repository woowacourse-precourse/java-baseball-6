package baseball.service;

import baseball.domain.User;

public class UserService {
    private User user;

    public UserService(User user) {
        this.user = user;
    }

    public String returnBaseballNumber() {
        return user.returnBaseballNumber();
    }

    public String returnRetryNumber() {
        return user.returnRetryNumber();
    }

    public void inputNumber() {
        user.inputNumber();

        if (!user.isValidInput()) {
            throw new IllegalArgumentException("야구 숫자 입력이 잘못되었습니다.");

        }

    }

    public void inputRestart() {
        user.selectRetry();

        if (!user.isValidRetry()) {
            throw new IllegalArgumentException("재시작 옵션 값이 잘못 입력되었습니다.");
        }
    }
}