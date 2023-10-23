package baseball.service;

import baseball.domain.User;
import java.util.List;

public class UserService {
    private User user;

    public UserService() {
        user = new User();
    }

    public List<Integer> generateInput() {
        return user.enterNum();
    }

    public void resetInput() {
        user.reset();
    }
}
