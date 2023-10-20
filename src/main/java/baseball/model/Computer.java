package baseball.model;

import java.util.List;

public class Computer {
    private List<Integer> numbers;
    private int ball;
    private int strike;

    public Computer() {
        this.ball = 0;
        this.strike = 0;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "numbers=" + numbers +
                ", ball=" + ball +
                ", strike=" + strike +
                '}';
    }
}
