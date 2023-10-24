package baseball.domain;

import java.util.List;

public class BaseBalls {
    private final ComputerNumber computerNumber;//컴퓨터가 생성한 번호

    public BaseBalls(List<CompareNumber> generatedBall) {
        this.computerNumber = new ComputerNumber(generatedBall);
    }

    public GameResult compare(List<CompareNumber> userBalls) {
        GameResult gameResult = new GameResult();
        userBalls.forEach(v -> {
            BallScore ballScore = computerNumber.getScore(v);
            gameResult.saveResult(ballScore);
        });
        return gameResult;
    }
}
