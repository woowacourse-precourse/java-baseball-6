package baseball.domain;

import java.util.Arrays;
import java.util.List;

public class Referee {

    public List<Integer> compare(List<Integer> computer, List<Integer> player) {
        final Judgement judgement = new Judgement();
        int correctCounts = judgement.correctCounts(computer, player);
        int strike = 0;

        for (int i = 0; i < player.size(); i++) {
            if (judgement.hasPlace(computer, i, player.get(i))) {
                strike++;
            }
        }
        int ball = correctCounts - strike;
        return Arrays.asList(strike, ball);
    }

    public boolean doesWin(List<Integer> result) {
        int strike = result.get(0);
        return strike == 3;
    }


}
