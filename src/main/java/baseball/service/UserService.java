package baseball.service;

import baseball.domain.User;

import java.util.List;

public class UserService {
    private User user;

    public UserService() {
        user = new User();
    }

    public List<Integer> generateInput() {
        user.enterNum();
        return user.getUserNumber();
    }

    public void resetInput() {
        user.reset();
    }
}
