package baseball;

import java.util.List;

public class Referee {
    public RoundResult judge(List<Integer> catcher, List<Integer> pitcher) {
        int strike = 0, ball = 0;

        for (int i = 0; i < catcher.size(); i++) {
            int pitcherNum = pitcher.get(i);
            if (pitcherNum == catcher.get(i)) {
                strike++;
            }
            else if (catcher.contains(pitcherNum)) {
                ball++;
            }
        }

        return new RoundResult(strike, ball);
    }
}
