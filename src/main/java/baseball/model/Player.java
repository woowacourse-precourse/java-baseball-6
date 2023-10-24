package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String userNumber;
    private List<Integer> userNum = new ArrayList<>();
    private int ball = 0;
    private int strike = 0;

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public List<Integer> getUserNum() {
        return userNum;
    }

    public void setUserNum(List<Integer> userNum) {
        this.userNum = userNum;
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

    @Override
    public String toString() {
        return "Player{" +
                "userNum=" + userNum +
                ", ball=" + ball +
                ", strike=" + strike +
                '}';
    }

}
