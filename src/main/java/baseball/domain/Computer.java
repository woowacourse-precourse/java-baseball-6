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

    public void calculateBallCount(Player player) {
        for (int position = 0; position < BallConstant.BALL_LENGTH.getValue(); position++) {
            int playerNumber = player.getByPosition(position);
            BallStatus ballStatus = decideBall(playerNumber);
            System.out.println(ballStatus);
        }
    }

    private BallStatus decideBall(int playerNumber) {
        boolean isBall = isBall(playerNumber);
        return BallStatus.getBallStatus(isBall);
    }

    private boolean isBall(int playerNumber) {
        return elements.contains(playerNumber);
    }
}