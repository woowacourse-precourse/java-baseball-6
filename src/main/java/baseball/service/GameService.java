package baseball.service;

import baseball.domain.GameNumber;
import baseball.domain.GameStatus;
import baseball.domain.Judgement;

public class GameService {

    private final GameStatus gameStatus;

    private GameService() {
        this.gameStatus = new GameStatus();
    }

    public static GameService startNewGame() {
        return new GameService();
    }

    public GameStatus compareNumber(GameNumber computerNumber, GameNumber userNumber) {
        for (int index = 0; index < 3; index++) {
            Judgement judgement = checkNumber(computerNumber, userNumber, index);
            gameStatus.updateCount(judgement);
        }
        return gameStatus;
    }

    private static Judgement checkNumber(GameNumber answerNumber, GameNumber userNumber, int index) {
        int indexNumber = userNumber.getNumberOfIndex(index);
        boolean isContain = answerNumber.isContain(indexNumber);
        boolean isInPlace = answerNumber.isInPlace(index, indexNumber);
        return Judgement.judge(isContain, isInPlace);
    }

    public boolean isNotDone() {
        return gameStatus.isNotThreeStrike();
    }

    public void resetStatus() {
        gameStatus.reset();
    }
}
