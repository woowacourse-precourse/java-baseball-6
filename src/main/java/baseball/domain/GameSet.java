package baseball.domain;

public class GameSet {
    private final GameNumbers computerGameNumbers;
    private boolean isSetEnd;

    public GameSet() {
        computerGameNumbers = RandomGameNumbersGenerator.generateRandomGameNumbers();
        isSetEnd = false;
    }

    public RoundResult playRound(String userNumberInput) {
        GameNumbers userGameNumbers = new GameNumbers(userNumberInput);
        RoundResult roundResult = new RoundResult(userGameNumbers, computerGameNumbers);

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
