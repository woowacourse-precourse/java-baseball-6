package baseball.service;

import baseball.domain.User;

import java.util.List;

public class userService {
    private User user = new User();

    public void generateInput() {
        List<Integer> inputNumber = user.getUserNumber();
        while (inputNumber.size() < 3) {
            user.enterNum();
        }
    }

    public void resetInput() {
        user.reset();
    }
}
