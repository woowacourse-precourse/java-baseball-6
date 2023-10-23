package baseball.domain;

import baseball.domain.gamenumber.GameNumbers;

public class GameSet {
    private final GameNumbers targetGameNumbers;
    private boolean isSetEnd;

    public GameSet(GameNumbers targetGameNumbers) {
        this.targetGameNumbers = targetGameNumbers;
        isSetEnd = false;
    }

    public RoundResult playRound(GameNumbers userGameNumbers) {
        RoundResult roundResult = new RoundResult(userGameNumbers, targetGameNumbers);
        checkSetEnd(roundResult);

        return roundResult;
    }

    private void checkSetEnd(RoundResult roundResult) {
        if (roundResult.getStrikeCount() == GameNumbers.LENGTH) {
            isSetEnd = true;
        }
    }

    public boolean isSetEnd() {
        return isSetEnd;
    }
}
