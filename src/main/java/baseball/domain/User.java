package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> userGameNumbers = new ArrayList<>();

    public List<Integer> getUserGameNumbers() {
        return userGameNumbers;
    }

    public void setUserGameNumbers(List<Integer> userGameNumbers) {
        this.userGameNumbers = userGameNumbers;
    }
}