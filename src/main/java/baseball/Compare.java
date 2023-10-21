package baseball;

import java.util.List;

public class Compare {
    int ball;
    int strike;
    public void setBallAndStrike(List<Integer> userInput, List<Integer> answer){
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < userInput.size(); i++) {
            if (userInput.get(i).equals(answer.get(i))) {
                strike++;
            }
            else if (answer.contains(userInput.get(i))) {
                ball++;
            }
        }
        setBall(ball);
        setStrike(strike);
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
}
