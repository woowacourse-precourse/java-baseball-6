package baseball.service;

import baseball.domain.GameNumber;
import baseball.domain.GameResult;
import baseball.domain.Judgement;

public class GameService {

    private final GameResult gameResult;

    public static GameService startNewGame() {
        return new GameService();
    }

    private GameService() {
        this.gameResult = new GameResult();
    }

    public GameResult compareNumber(GameNumber answerNumber, GameNumber userNumber) {
        for (int index = 0; index < 3; index++) {
            Judgement judgement = checkNumber(answerNumber, userNumber, index);
            gameResult.updateCount(judgement);
        }
        return gameResult;
    }

    private Judgement checkNumber(GameNumber answerNumber, GameNumber userNumber, int index) {
        int indexNumber = userNumber.getNumberOfIndex(index);
        boolean isContain = answerNumber.isContain(indexNumber);
        boolean isInPlace = answerNumber.isInPlace(index, indexNumber);
        return Judgement.judge(isContain, isInPlace);
    }

    public boolean isNotDone() {
        return gameResult.isNotThreeStrike();
    }

    public void resetResult() {
        gameResult.reset();
    }
}
