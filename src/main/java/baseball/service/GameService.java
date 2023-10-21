package baseball.service;

import baseball.domain.GameNumber;
import baseball.domain.GameResult;
import baseball.domain.Judgement;

import java.util.List;

public class GameService {

    private final GameResult gameResult;
    private final GameNumber answerNumber;

    public static GameService startNewGame() {
        return new GameService();
    }

    private GameService() {
        this.gameResult = new GameResult();
        this.answerNumber = createNewAnswer();
    }

    private GameNumber createNewAnswer() {
        List<Integer> generatedNumber = NumberGenerator.generateNumber(3);
        return new GameNumber(generatedNumber);
    }

    public GameResult compareNumber(GameNumber userNumber) {
        for (int index = 0; index < 3; index++) {
            Judgement judgement = checkNumber(userNumber, index);
            gameResult.updateCount(judgement);
        }
        return gameResult;
    }

    private Judgement checkNumber(GameNumber userNumber, int index) {
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
