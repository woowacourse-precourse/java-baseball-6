package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> number = new ArrayList<>();
    private int ball;
    private int strike;

    public List<Integer> getNumber() {
        return number;
    }

    public void resetNumber() {
        number.clear();
    }

    public boolean validateNumber(String numberFromUser) {
        //3자리인지
        if (numberFromUser.length() != 3) {
            return false;
        }

        //0을 포함하지 않는지
        if (numberFromUser.contains("0")) {
            return false;
        }

        //같은 숫자 없는지, 숫자가 맞는지
        String[] newNumbers = numberFromUser.split("");
        try {
            for (String newNum : newNumbers) {
                if (number.contains(Integer.parseInt(newNum))) {
                    return false;
                }
                addNumber(Integer.parseInt(newNum));
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public int getBall() {
        return this.ball;
    }

    public void addBall() {
        this.ball++;
    }

    public int getStrike() {
        return this.strike;
    }

    public void addStrike() {
        this.strike++;
    }

    public void resetBallAndStrike() {
        ball = 0;
        strike = 0;
    }

    public boolean finishGame() {
        return strike == 3;
    }

    private void addNumber(int newNumber) {
        number.add(newNumber);
    }
}
