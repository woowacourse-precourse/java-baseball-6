package baseball.domain;

import java.util.List;

public class BaseBalls {
    private final ComputerNumber computerNumber;//컴퓨터가 생성한 번호

    public BaseBalls(List<CompareNumber> generatedBall) {
        this.computerNumber = new ComputerNumber(generatedBall);
    }

    public GameResult compare(UserNumber userBalls) {
        return userBalls.getScore(computerNumber);
    }
}
