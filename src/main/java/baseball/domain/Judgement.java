package baseball.domain;

import java.util.List;

public class Judgement {

    public int[] judgement(List<Integer> opponent, List<Integer> player) {

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            boolean isStrike = (opponent.get(i) == player.get(i));
            strike += Boolean.compare(isStrike, false);

            boolean isBall = (opponent.contains(player.get(i)));
            ball += Boolean.compare(isBall, false);
        }
        return new int[]{strike, ball - strike};
    }
}