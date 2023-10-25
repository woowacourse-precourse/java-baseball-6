package baseball.engine.manager;

import baseball.constant.BaseballSystemPolicy;
import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.engine.dto.Hint;

public record Referee() {

    public Hint ballCount(Player player, Computer computer) {
        int strike = 0;
        int ball = 0;
        int limitLength = BaseballSystemPolicy.LIMIT_LENGTH.getCondition();

        for (int index = 0; index < limitLength; index++) {
            Integer playerValue = player.getValue(index);

            if (computer.exactlyMatch(index, playerValue)) {
                strike++;
            } else if (computer.isContains(playerValue)) {
                ball++;
            }
        }

        return new Hint(strike, ball);
    }
}
