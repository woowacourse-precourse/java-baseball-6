package baseball.model;

import java.util.List;
import java.util.stream.IntStream;

public class UserComputerCompare {
    private final Computer computer;
    private final Player player;
    private final Result result;

    private UserComputerCompare(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
        this.result = Result.initialBallCount();
    }

    public static UserComputerCompare judge(Computer computer, Player player) {
        return new UserComputerCompare(computer, player);
    }


    public Result getBallCountJudgement() {
        List<Integer> computerNumber = computer.getComputerNumber();

        IntStream.range(0, 3)
                .forEach(i -> {
                    int number = player.getNumberByPosition(i);
                    if (computer.hasCommonNumber(number)) {
                        BallCount key = computerNumber.indexOf(number) == i ? BallCount.STRIKE : BallCount.BALL;
                        result.updateBallCount(key);
                    }
                });

        return result;
    }
}