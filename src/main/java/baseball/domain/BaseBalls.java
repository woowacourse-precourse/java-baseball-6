package baseball.domain;

import java.util.List;

public class BaseBalls {
    private final List<CompareNumber> generatedBalls;//컴퓨터가 생성한 번호

    public BaseBalls(List<CompareNumber> generatedBall) {
        this.generatedBalls = generatedBall;
    }
    public GameResult compare(List<CompareNumber> userBalls) {
        GameResult gameResult = new GameResult();
        for (int i = 0; i < userBalls.size(); i++) {
            CompareNumber compareNumber = userBalls.get(i);
            gameResult.saveResult(getScore(compareNumber));
        }
        return gameResult;
    }

    private BallScore getScore(CompareNumber userBall) {
        //인자로 CompareNumber(pos, num)을 받는다. -> generatedBalls의 각 객체의 해시코드와 num값을 비교한다.
        //generatedBalls 에는 각 자리의 숫자를 CompareNumber(pos, num) 의 형식으로 변환한 객체가 들어있다.
        return generatedBalls.stream()
                .map(v -> v.calculateScore(userBall))
                .filter(v -> !v.equals(BallScore.NOTHING))
                .findFirst().orElse(BallScore.NOTHING);
    }
}
