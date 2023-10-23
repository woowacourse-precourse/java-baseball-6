package baseball.service;

import baseball.domain.*;
import baseball.domain.number.AnswerNumber;
import baseball.domain.number.UserNumber;

public class GameService {

    private final GameResult gameResult;

    public static GameService startNewGame() {
        return new GameService();
    }

    private GameService() {
        this.gameResult = new GameResult();
    }

    public GameResult compareNumber(AnswerNumber answerNumber, UserNumber userNumber) {
        for (int index = 0; index < 3; index++) {
            Judgement judgement = checkNumber(answerNumber, userNumber, index);
            gameResult.updateCount(judgement);
        }
        return gameResult;
    }

    private Judgement checkNumber(AnswerNumber answerNumber, UserNumber userNumber, int index) {
        int indexNumber = userNumber.getNumberOfIndex(index);
        boolean isContains = answerNumber.isContain(indexNumber);
        boolean isInPlace = answerNumber.isInPlace(index, indexNumber);
        return Judgement.judge(isContains, isInPlace);
    }

    public boolean isNotDone() {
        return gameResult.isNotThreeStrike();
    }

    public void setCountZero() {
        gameResult.initCount();
    }
}
