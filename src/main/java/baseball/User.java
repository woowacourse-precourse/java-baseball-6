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

    private void checkInputHasChar(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("This input is not Integer: " + input);
        }
    }

    private void checkInputString(String input) {
        checkInputLength(input);
        checkInputHasZero(input);
        checkInputHasChar(input);
    }

    private void addNumber(int num) {
        if (user.contains(num) || num < 1 || num > 9) {
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
        checkInputString(input);
        String[] tokens = input.split("");
        for (String str : tokens) {
            addNumber(Integer.parseInt(str));
        }
    }
}
