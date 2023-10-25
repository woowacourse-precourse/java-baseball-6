package baseball.domain;

import static baseball.utils.Constants.NUMBER_SIZE;

import baseball.dto.BaseballResultDto;
import java.util.stream.IntStream;

public class BaseballGame {
    private Baseball baseball;

    public void compare(Computer computer, Player player) {
        int strike = countStrike(computer, player);
        int ball = countBall(computer, player);
        this.baseball = new Baseball(ball, strike);
    }

    private int countStrike(Computer computer, Player player) {
        return (int) IntStream.range(0, NUMBER_SIZE)
                .filter(idx -> computer.compareStrike(player, idx))
                .count();
    }

    private int countBall(Computer computer, Player player) {
        return (int) IntStream.range(0, NUMBER_SIZE)
                .filter(idx -> computer.compareBall(player, idx))
                .count();
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
