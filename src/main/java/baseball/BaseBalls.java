package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseBalls {
    private final List<CompareNumber> generatedBalls;//컴퓨터가 생성한 번호

    public BaseBalls(List<Integer> generatedBall) {
        this.generatedBalls = compareNumberFormat(generatedBall);
    }

    //컴퓨터가 생성한 번호를 CompareNumber 객체에 담는다
    private static List<CompareNumber> compareNumberFormat(List<Integer> generatedBall) {
        ArrayList<CompareNumber> compareNumbers = new ArrayList<>();
        generatedBall.forEach(v -> {
            compareNumbers.add(new CompareNumber(compareNumbers.size() + 1, v));
        });
        return compareNumbers;
    }


    public List<BallScore> compare(List<Integer> userBalls) {
        List<BallScore> ballScores = new ArrayList<>();
        for (int i = 0; i < userBalls.size(); i++) {
            CompareNumber compareNumber = new CompareNumber(i + 1, userBalls.get(i));
            ballScores.add(getScore(compareNumber));
        }
        return ballScores;
    }

    private BallScore getScore(CompareNumber userBall) {
        //인자로 CompareNumber(pos, num)을 받는다. -> generatedBalls의 각 객체의 해시코드와 num값을 비교한다.
        //generatedBalls 에는 각 자리의 숫자를 CompareNumber(pos, num) 의 형식으로 변환한 객체가 들어있다.
        BallScore ballScore = generatedBalls.stream()
                .map(v -> v.calculateScore(userBall))
                .filter(v -> !v.equals(BallScore.NOTHING))
                .findFirst().orElse(BallScore.NOTHING);
        return ballScore;
/*
        generatedBalls.forEach(v -> {
            BallScore ballScore = v.calculateScore(compareNumber);
            System.out.println(ballScore);
        });
*/
    }
}
