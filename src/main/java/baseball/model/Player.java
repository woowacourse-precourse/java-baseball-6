package baseball.model;

import baseball.domain.Validator;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> userNumbers = new ArrayList<>();

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

    public void setUserNumbers(List<Integer> userNum) {
        this.userNumbers = userNum;
    }

    public List<Integer> checkDuplication(String userNum) {
        return Validator.checkForDuplicateNumbers(userNum);
    }

}
