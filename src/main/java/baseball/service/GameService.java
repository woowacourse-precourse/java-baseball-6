package baseball.service;

import baseball.domain.GameNumber;
import baseball.domain.GameStatus;
import baseball.domain.Judgement;

import java.util.List;

public class GameService {

    private final GameStatus gameStatus;
    private final GameNumber answerNumber;

    public static GameService startNewGame() {
        return new GameService();
    }

    private GameService() {
        this.gameStatus = new GameStatus();
        this.answerNumber = createNewAnswer();
    }

    private GameNumber createNewAnswer() {
        List<Integer> generatedNumber = NumberGenerator.generateNumber(3);
        return new GameNumber(generatedNumber);
    }

    public GameStatus compareNumber(GameNumber userNumber) {
        for (int index = 0; index < 3; index++) {
            Judgement judgement = checkNumber(answerNumber, userNumber, index);
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
