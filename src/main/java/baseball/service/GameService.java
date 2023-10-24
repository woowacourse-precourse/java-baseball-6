package baseball.service;

import baseball.domain.Balls;
import baseball.domain.Score;
import baseball.dto.ScoreDto;
import baseball.util.Util;

import java.util.List;

public class GameService {

    private Balls answerBalls;
    private Balls userBalls;
    private Score score;

    public void createAnswerBalls() {

        List<Integer> randomNumbers = Util.createRandomNumbers(3);
        answerBalls = new Balls(randomNumbers);
    }

    public void play(String userInput) {

        userBalls = createUserBalls(userInput);
        score = createScore();
    }

    public ScoreDto createScoreDto() {

        return new ScoreDto(score.getStrike(), score.getBall());
    }

    public boolean isAnswer() {

        if(score.isAllStrike()) {
            return true;
        }

        if(score.isAllStrike()) {
            return true;
        }

        return false;
    }

    private Balls createUserBalls(String userInput) {

        return new Balls(Util.stringToIntegerList(userInput));
    }

    private Score createScore() {

        return Score.create(answerBalls, userBalls);
    }
}
