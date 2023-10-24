package baseball;

import java.util.List;

public class BaseBallGame {

    private final RandomNumberGenerator randomNumberGenerator;

    public BaseBallGame(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public List<Integer> createAnswerNumbers() {
        return randomNumberGenerator.createRandomNumbers();
    }

    public void createGameResult(List<Integer> tryNumbers, List<Integer> answerNumbers) {
        GameReferee gameReferee = new GameReferee(new Ball(answerNumbers));
        Score score = gameReferee.judge(new Ball(tryNumbers));

        // TODO: 게임 결과 반환하기!
    }
}
