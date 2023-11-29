package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> userNumbers = new ArrayList<>();
    private int ball = 0;
    private int strike = 0;

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

    public void setUserNumbers(List<Integer> userNum) {
        this.userNumbers = userNum;
    }

    public List<Integer> checkDuplication(String userNum) {
        return Array.checkForDuplicateNumbers(userNum);
    }

    public int getBall() {
        return ball;
    }

    public void addBall() {
        ball++;
    }

    public int getStrike() {
        return strike;
    }

    public void addStrike() {
        strike++;
    }
    
}
