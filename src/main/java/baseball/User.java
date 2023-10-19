package baseball;

import java.util.List;

public class User {

    List<Integer> numbers;
    boolean gameStatus;

    public User() {
        this.gameStatus = true;
    }

    public void validateNumbersFromUser(String input) {
        if(input.length() != 3) {
            throw new IllegalArgumentException();
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if(input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2)) {
            throw new IllegalArgumentException();
        }
    }
}
