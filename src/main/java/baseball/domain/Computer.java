package baseball.domain;

import baseball.dto.CountResultDto;

public class Computer {
    private final Number number;

    public Computer(Number number) {
        this.number = number;
    }

    public CountResultDto match(Player player) {
        int strikeCount = player.countStrike(number);
        int ballCount = player.countBall(number);
        return new CountResultDto(strikeCount, ballCount);
    }
}
