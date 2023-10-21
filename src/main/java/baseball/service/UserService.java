package baseball.service;

import baseball.domain.User;

import java.util.List;

public class UserService {
    private User user;

    public UserService() {
        user = new User();
    }

    public List<Integer> generateInput() {
        List<Integer> inputNumber = user.getUserNumber();
        while (inputNumber.size() < 3) {
            user.enterNum();
        }

        return inputNumber;
    }

    public void resetInput() {
        user.reset();
    }
}
