package baseball.domain;

import baseball.util.InvalidInputException;
import java.util.HashSet;

public class User {
    private String data;

    private User() {
    }

    public User(String data) {
        if (!isValidData(data)) {
            throw new InvalidInputException("유효하지 않은 데이터입니다." + data);
        }
        this.data = data;
    }

    public String getData() {
        return data;
    }

    private boolean isValidData(String data) {
        return isValidLength(data) && isValidPattern(data) && isDuplicates(data);
    }

    private boolean isValidLength(String data) {
        return data.length() == 3;
    }

    private boolean isValidPattern(String data) {
        return data.matches("[1-9]+$");
    }

    private boolean isDuplicates(String data) {
        HashSet<Character> unique = new HashSet<>();
        for (char x : data.toCharArray()) {
            if (unique.contains(x)) {
                return false;
            }
            unique.add(x);
        }
        return true;
    }
}
