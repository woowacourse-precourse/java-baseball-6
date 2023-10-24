package baseball.model;

import static baseball.util.Constants.BALL_LENGTH;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class UserComputerCompare {
    private final Computer computer;
    private final Player player;

    private UserComputerCompare(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public static UserComputerCompare judge(Computer computer, Player player) {
        return new UserComputerCompare(computer, player);
    }

    public Map<BallCount, Integer> getBallCountJudgement() {
        Map<BallCount, Integer> ballCount = new HashMap<>();
        ballCount.put(BallCount.BALL, 0);
        ballCount.put(BallCount.STRIKE, 0);

        List<Integer> computerNumber = computer.getComputerNumber();
        List<Integer> playerNumber = player.getPlayerNumber();

        IntStream.range(0, BALL_LENGTH)
                .forEach(i -> updateBallCount(ballCount, computerNumber, playerNumber, i));

        return ballCount;
    }

    private void updateBallCount(Map<BallCount, Integer> ballCount, List<Integer> computerNumber,
                                 List<Integer> playerNumber, int index) {
        Integer currentPlayerNum = playerNumber.get(index);
        if (computerNumber.contains(currentPlayerNum)) {
            BallCount key = index == computerNumber.indexOf(currentPlayerNum) ? BallCount.STRIKE : BallCount.BALL;
            ballCount.put(key, ballCount.get(key) + 1);
        }
    }
}