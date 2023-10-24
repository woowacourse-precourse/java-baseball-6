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

    public String createGameResult(List<Integer> tryNumbers, List<Integer> answerNumbers) {
        GameReferee gameReferee = new GameReferee(new Ball(answerNumbers));
        return gameReferee.judge(new Ball(tryNumbers)).getName();
    }
}
