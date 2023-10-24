package baseball.model;

import java.util.List;

public class NumberModel {
    private List<Integer> computerNumbers;
    private List<Integer> userNumbers;

    public void setComputerNumbers(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public void setUserNumbers(List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }


}
