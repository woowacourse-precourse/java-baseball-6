package baseball.domain;

import baseball.dto.BaseballResultDto;

public class BaseballGame {
    private Baseball baseball;

    public void compare(Computer computer, Player player) {
        int strike = computer.compareSameIndexNumber(player);
        int ball = computer.compareContainNumber(player) - strike;
        this.baseball = new Baseball(ball, strike);
    }

    public BaseballResultDto getGameResult() {
        BaseballResult result = BaseballResult.of(baseball);
        return new BaseballResultDto(baseball.ball(), baseball.strike(), result.getMessageFormat());
    }

    public Boolean isGameOver() {
        return baseball.isAllStrike();
    }

    public Baseball getBaseball() {
        return baseball;
    }
}
