package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> user;

    public User() {
        user = new ArrayList<>();
    }

    public void generateUserNumber(String inputValue) {
        if (!user.isEmpty()) {
            user.clear();
        }

        for (int i = 0; i < inputValue.length(); i++) {
            int userNumber = parseNumber(inputValue.charAt(i));

            if (user.contains(userNumber)) {
                wrongNumberInput();
            }

            user.add(userNumber);
        }
    }

    public int parseNumber(char character) {
        return character - '0';
    }

    public void validateLength(String inputValue) {
        if (inputValue.length() != Baseball.NUMBERS_SIZE) {
            wrongNumberInput();
        }
    }

    public void validateRange(String inputValue) {
        for (int i = 0; i < inputValue.length(); i++) {
            int userNumber = parseNumber(inputValue.charAt(i));

            if (!(Baseball.MIN_NUMBER <= userNumber && userNumber <= Baseball.MAX_NUMBER)) {
                wrongNumberInput();
            }
        }
    }

    public int getUserNumber(final int i) {
        return user.get(i);
    }

    private void wrongNumberInput() {
        throw new IllegalArgumentException();
    }
}
