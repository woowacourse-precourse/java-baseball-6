package baseball.domain;

import baseball.constant.BallConstant;
import baseball.constant.BallStatus;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> elements;


    public Computer() {
        this.elements = createRandomNumbers();
    }

    public List<Integer> createRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < BallConstant.BALL_LENGTH.getValue()) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public GameResult calculateBallCount(Player player) {
        GameResult gameResult = new GameResult();
        for (int position = 0; position < BallConstant.BALL_LENGTH.getValue(); position++) {
            int playerNumber = player.getByPosition(position);
            BallStatus ballStatus = decideBall(playerNumber, position);
            gameResult.increaseCount(ballStatus);
        }
        return gameResult;
    }

    private BallStatus decideBall(int playerNumber, int position) {
        boolean isBall = isBall(playerNumber);
        boolean isStrike = isStrike(playerNumber, position);
        return BallStatus.getBallStatus(isBall, isStrike);
    }

    private boolean isBall(int playerNumber) {
        return elements.contains(playerNumber);
    }

    private boolean isStrike(int playerNumber, int position) {
        return playerNumber == elements.get(position);
    }
}