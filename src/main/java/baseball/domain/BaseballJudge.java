package baseball.domain;

import baseball.dto.CompareResult;

public class BaseballJudge {

    public static CompareResult judgeCompareResult(Player player, Computer computer) {
        Numbers playerNumbers = player.getNumbers();
        Numbers computerNumbers = computer.getNumbers();

        int strike = computerNumbers.calculateStrikes(playerNumbers);
        int ball = computerNumbers.calculateBalls(playerNumbers);
        return new CompareResult(strike, ball);
    }
}
