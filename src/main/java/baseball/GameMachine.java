package baseball;

public class GameMachine {
    private final String[] computerNumbers;
    private String[] playerNumbers;

    public GameMachine(String[] computerNumbers, String[] playerNumbers) {
        this.computerNumbers = computerNumbers;
        this.playerNumbers = playerNumbers;
    }

    public void setPlayerNumbers(String[] playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public GameResult playGame() {
        int ball = 0;
        int strike = 0;
        for (int computerCount = 0; computerCount < Message.TOTAL_COMPUTER_NUMBERS; computerCount++) {
            for (int playerCount = 0; playerCount < Message.TOTAL_PLAYER_NUMBERS; playerCount++) {
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
