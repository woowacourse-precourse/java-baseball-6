package baseball.controller;

import baseball.model.User;

import java.util.List;

public class UserController {
    private User user = new User();

    public UserController() {}

    public void setNumbers(List<Integer> numbers) {
        user.setNumbers(numbers);
    }
    public List<Integer> getNumbers() {
        return user.getNumbers();
    }
}
