package baseball.domain;
import java.util.List;

public class Judgement {

    public int[] judgement(List<Integer> opponent, List<Integer> player) {

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (opponent.get(i) == player.get(i)) {
                ++strike;
            }
            if (opponent.contains(player.get(i))) {
                ++ball;
            };
        }
        return new int[]{strike, ball - strike};
    }
}
