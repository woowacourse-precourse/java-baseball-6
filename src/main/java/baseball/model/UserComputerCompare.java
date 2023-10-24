package baseball.model;

import java.util.Map;
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


    public Map<BallCount, Integer> getBallCountJudgement() {
        IntStream.range(0, 3)
                .forEach(this::processPlayerNumber);

        return result.getResult();
    }

    private void processPlayerNumber(int index) {
        int number = player.getNumberByPosition(index);
        if (hasCommonNumber(number)) {
            BallCount key = isInSamePosition(index) ? BallCount.STRIKE : BallCount.BALL;
            result.updateBallCount(key);
        }
    }

    private boolean isInSamePosition(int position) {
        return position == computer.getComputerNumber().indexOf(player.getNumberByPosition(position));
    }

    private boolean hasCommonNumber(int number) {
        return computer.getComputerNumber().contains(number);
    }
}