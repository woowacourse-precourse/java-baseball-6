package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<Integer> user;

    public User() {
        this.user = new ArrayList<>();
    }

    private void checkInputLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("Invalid input length.");
        }
    }

    private void checkInputHasZero(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException("This input includes zero.");
        }
    }

    private void checkValidInputNumber(String input) {
        checkInputLength(input);
        checkInputHasZero(input);
    }

    private void addNumber(int num) {
        if (user.contains(num)) {
            throw new IllegalArgumentException("This is already contained: " + num);
        }
        user.add(num);
    }

    public void clearUser() {
        user.clear();
    }

    public List<Integer> getUser() {
        return user;
    }

    public void setUser(String input) {
        checkValidInputNumber(input);
        String[] tokens = input.split("");
        for (String str : tokens) {
            addNumber(Integer.parseInt(str));
        }
    }
}
