package baseball.dto.validator;

import baseball.domain.BaseballGame;
import baseball.dto.BattedBallsDTO;
import baseball.exception.BallDuplicatedException;
import baseball.exception.InvalidBallCountException;
import baseball.exception.InvalidBallContentException;
import java.util.HashSet;
import java.util.Set;

public class BattedBallsValidator {

    public void validate(BattedBallsDTO battedBallsDTO) {
        String battedBalls = battedBallsDTO.getBattedBalls();
        validBallCount(battedBalls);
        validateBalls(battedBalls);
    }

    private void validBallCount(String balls) {
        if (balls.length() != BaseballGame.BALL_COUNT) {
            throw new InvalidBallCountException(balls.length());
        }
    }

    private void validateBalls(String balls) {
        Set<Character> prevBalls = new HashSet<>();
        for (char ball : balls.toCharArray()) {
            validateBall(ball);
            if (prevBalls.contains(ball)) {
                throw new BallDuplicatedException(ball);
            }
            prevBalls.add(ball);
        }
    }

    private void validateBall(char ball) {
        if (!Character.isDigit(ball) || ball == '0') {
            throw new InvalidBallContentException(ball);
        }
    }
}
