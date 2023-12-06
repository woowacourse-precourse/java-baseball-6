package baseball.domain;

import baseball.model.Result;
import java.util.List;

public class Referee {

    public Result compare(List<Integer> computer, List<Integer> player) {
        final Judgment judgment = new Judgment();
        int correctCount = judgment.correctCount(computer, player);

        int strike = 0;
        for (int i = 0; i < player.size(); i++) {
            if (judgment.hasPlace(computer, i, player.get(i))) {
                strike++;
            }
        }

        int ball = correctCount - strike;

        return new Result(ball, strike);
    }
}
