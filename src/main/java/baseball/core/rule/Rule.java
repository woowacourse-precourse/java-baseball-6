package baseball.core.rule;

import baseball.core.rule.PickedNumbers;

public interface Rule {

    ScoreResult calculatePoints(PickedNumbers pickedNumbers);

}
