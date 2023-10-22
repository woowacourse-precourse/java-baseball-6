package baseball;

public class GameMachine {

    private final String[] computerNumbers;
    private String[] playerNumbers;
    private static final int TOTAL_COMPUTER_NUMBERS = 3;
    private static final int TOTAL_PLAYER_NUMBERS = 3;

    public GameMachine(String[] computerNumbers, String[] playerNumbers) {
        this.computerNumbers = computerNumbers;
        this.playerNumbers = playerNumbers;
    }

    public GameResult playGame() {
        int ball = 0;
        int strike = 0;
        for (int computerCount = 0; computerCount < TOTAL_COMPUTER_NUMBERS; computerCount++) {
            for (int playerCount = 0; playerCount < TOTAL_PLAYER_NUMBERS; playerCount++) {
                if (this.computerNumbers[computerCount].equals(this.playerNumbers[playerCount])) {
                    if (computerCount == playerCount) {
                        strike++;
                    }
                    if (computerCount != playerCount) {
                        ball++;
                    }
                }
            }
        }
        return new GameResult(ball, strike);
    }
}
