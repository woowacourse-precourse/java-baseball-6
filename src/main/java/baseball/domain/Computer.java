package baseball.domain;

import static baseball.constant.BaseballConstant.NUMBER_OF_TARGET;

import baseball.model.Score;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Computer {
    private final List<Integer> targets = new ArrayList<>();

    public void initTargets() {
        targets.clear();
        for (int i = 0; i < NUMBER_OF_TARGET; ++i) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            while (targets.contains(randomNumber)) {
                randomNumber = Randoms.pickNumberInRange(1, 9);
            }
            targets.add(randomNumber);
        }
    }

    public void gradePredictions(Player player) {
        Score score = player.getScore();
        for (int i = 0; i < NUMBER_OF_TARGET; ++i) {
            gradePrediction(score, player.getPrediction(i), i);
        }
    }

    public void gradePrediction(Score score, Integer prediction, int idx) {
        if (targets.contains(prediction)) {
            if (Objects.equals(targets.get(idx), prediction)) {
                score.incrementStrike();
                return;
            }
            score.incrementBall();
        }
    }
}
