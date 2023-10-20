package baseball.entity;

import java.util.Objects;
import java.util.Optional;

public class BaseballGame {

    private static final String UNKNOWN_GENERATOR_MESSAGE = "알 수 없는 공 생성기(null)로 객체를 생성할 수 없습니다.";

    private final Balls answerBalls;
    private BaseballGameStatus status;

    private BaseballGame(BallsGenerator ballsGenerator) {
        this.answerBalls = ballsGenerator.generate();
        this.status = BaseballGameStatus.PROGRESS;
    }

    public static BaseballGame from(BallsGenerator ballsGenerator) {
        checkBallsGeneratorNonNull(ballsGenerator);

        return new BaseballGame(ballsGenerator);
    }

    private static void checkBallsGeneratorNonNull(BallsGenerator ballsGenerator) {
        Optional.ofNullable(ballsGenerator)
                .orElseThrow(() -> new IllegalArgumentException(UNKNOWN_GENERATOR_MESSAGE));
    }

    public PlayResult play(Balls balls) {
        PlayResult result = answerBalls.play(balls);

        if (isPlayerWin(result)) {
            status = BaseballGameStatus.END;
        }

        return result;
    }

    private boolean isPlayerWin(PlayResult result) {
        return result.getStrikeCount() == answerBalls.count();
    }

    public boolean isEnd() {
        return status.isEnd();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballGame that = (BaseballGame) o;
        return Objects.equals(answerBalls, that.answerBalls) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerBalls, status);
    }
}
