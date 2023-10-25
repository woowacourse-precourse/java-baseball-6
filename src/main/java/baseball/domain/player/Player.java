package baseball.domain.player;

import baseball.domain.baseballnumber.BaseballNumbers;

public class Player {

    private BaseballNumbers numbers;

    public BaseballNumbers numbers() {
        return numbers;
    }

    public void changeNumbers(BaseballNumbers changeNumbers) {
        numbers = changeNumbers;
    }
}
