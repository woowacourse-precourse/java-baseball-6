package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class User {
    private List<String> userNumber;

    public User(List<String> userNumber) {
        this.userNumber = userNumber;
    }

    public User() {
        this.userNumber = new ArrayList<>();
    }

    public void setUserNumber(String[] userInput) {
        HashSet<String> set = new HashSet<>(List.of(userInput));
        if (set.size() != 3 || userInput.length > 3) {
            throw new IllegalArgumentException("서로 다른 세 자리 수를 입력해주세요.");
        }
        this.userNumber = List.of(userInput);
    }

    public List<String> getUserNumber() {
        return userNumber;
    }
}
