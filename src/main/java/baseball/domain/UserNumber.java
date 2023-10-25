package baseball.domain;

import java.util.List;

public class UserNumber {
    private final List<CompareNumber> userNumber;

    public UserNumber(List<CompareNumber> userNumber) {
        this.userNumber = userNumber;
    }

    public GameResult getScore(ComputerNumber computerNumber) {
        GameResult gameResult = new GameResult();
        userNumber.forEach(v -> {
            BallScore score = computerNumber.getScore(v);
            gameResult.saveResult(score);
        });
        return gameResult;
    }
}
