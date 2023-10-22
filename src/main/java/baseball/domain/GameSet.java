package baseball.domain;

public class GameSet {
    private final GameNumbers computerGameNumbers;

    public GameSet() {
        computerGameNumbers = RandomGameNumbersGenerator.generateRandomGameNumbers();
    }

    public RoundResult playRound(String userNumberInput) {
        GameNumbers userGameNumbers = new GameNumbers(userNumberInput);

        return new RoundResult(userGameNumbers, computerGameNumbers);
    }
}
