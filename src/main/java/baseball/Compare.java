package baseball;

import java.util.List;

public class Compare {
    public int Hit(List<Integer> computer, List<Integer> user) {
        int result = 0;
        for (int i = 0; i < user.size(); i++) {
            if (computer.contains(user.get(i))) {
                result++;
            }
        }
        return result;
    }

    public int Strikes(List<Integer> computer, List<Integer> user) {
        int strike = 0;
        for (int i = 0; i < user.size(); i++) {
            if (computer.get(i) == user.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    public String Classification(List<Integer> computer, List<Integer> user) {
        int total = Hit(computer, user);
        int strike = Strikes(computer, user);
        int ball = total - strike;
        if (total == 0) {
            return "??";
        } else if (strike == 0) {
            return ball + "?";
        } else if (ball == 0) {
            return strike + "?????";
        }
        return ball + "? " + strike + "?????";
    }
}