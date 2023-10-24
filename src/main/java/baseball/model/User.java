package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static User user;
    private List<Integer> number;
    private int strike, ball;

    private User() {
        number = new ArrayList<>();
    }

    public static User getUser() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void setNumber(List<Integer> number) {
        this.number = number;
    }

    public void calculateGameResult(List<Integer> computer) {
        ball = strike = 0;

        for (int i = 0; i < 3; i++) {
            int n = number.get(i);

            // out
            if (!computer.contains(n)) {
                continue;
            }

            int idx = computer.indexOf(n);
            if (idx != i) {
                ball++;
            } else {
                strike++;
            }
        }
    }

    public boolean gameFinish() {
        return (strike == 3);
    }
}
