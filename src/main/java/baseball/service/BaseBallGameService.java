package baseball.service;

import baseball.domain.Ball;
import baseball.domain.GameReferee;
import baseball.domain.RandomNumberGenerator;
import baseball.domain.Score;
import java.util.List;

public class BaseBallGameService {

    private final RandomNumberGenerator randomNumberGenerator;

    public BaseBallGameService(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public List<Integer> createAnswerNumbers() {
        return randomNumberGenerator.createRandomNumbers();
    }

    public Score createGameResult(List<Integer> tryNumbers, List<Integer> answerNumbers) {
        GameReferee gameReferee = new GameReferee(new Ball(answerNumbers));
        return gameReferee.judge(new Ball(tryNumbers));
    }
}
