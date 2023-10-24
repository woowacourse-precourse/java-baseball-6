package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Game {
    private int ball = 0;
    private int strike = 0;
    private List<Integer> computer;
    private List<Integer> number;

    public Game() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.computer = computer;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public void setNumber(List<Integer> number) {
        this.number = number;
    }

    public int getBall() {
        return this.ball;
    }

    public int getStrike() {
        return this.strike;
    }

    public List<Integer> getNumber() {
        return this.number;
    }

    public List<Integer> getComputer() {
        return this.computer;
    }
}
