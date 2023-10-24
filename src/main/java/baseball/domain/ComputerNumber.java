package baseball.domain;

import java.util.List;

public class ComputerNumber {
    private final List<CompareNumber> generatedBalls;

    public ComputerNumber(List<CompareNumber> generatedBalls) {
        this.generatedBalls = generatedBalls;
    }

    public BallScore getScore(CompareNumber userBall) {
        //인자로 CompareNumber(pos, num)을 받는다. -> generatedBalls의 각 객체의 해시코드와 num값을 비교한다.
        //generatedBalls 에는 각 자리의 숫자를 CompareNumber(pos, num) 의 형식으로 변환한 객체가 들어있다.
        return generatedBalls.stream()
                .map(v -> v.calculateScore(userBall))
                .filter(v -> !v.equals(BallScore.NOTHING))
                .findFirst().orElse(BallScore.NOTHING);
    }

}
