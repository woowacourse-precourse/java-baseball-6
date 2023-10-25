package baseball.deprecated;

import baseball.baseballgame.variables.Variables;

public class Game {
    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    private int strike;
    private int ball;

    private int N = Variables.NUM.getValue();

    public boolean checkAndCalcUserGuess(User user, Computer computer) {
        strike = 0;
        ball = 0;

        for (int i = 0; i < N; i++) {
            if (user.getUserList().get(i).equals(computer.getComputerList().get(i))) {
                strike++;
            } else if (computer.getComputerList().contains(user.getUserList().get(i))) {
                ball++;
            }
        }

        return (strike == 3);
    }
}
