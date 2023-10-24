package baseball.model;

public class Computer {

    private GameNumbers gameNumbersOfComputer;

    private static final int INITIAL_COUNT_VALUE = 0;

    public Computer() {
    }

    public void pickRandomNumbers() {
        this.gameNumbersOfComputer = GameNumbers.create();
    }

    public GameResult getResult(final GameNumbers gameNumbersOfPlayer) {
        final int strikes = countStrikes(gameNumbersOfPlayer);
        final int balls = countBalls(gameNumbersOfPlayer) - strikes;
        return new GameResult(balls, strikes);
    }

    private int countBalls(final GameNumbers gameNumbersOfPlayer) {
        int count = INITIAL_COUNT_VALUE;
        for (int i = 0; i < 3; i++) {
            int gameNumberOfPlayer = gameNumbersOfPlayer.valueAt(i);
            count = updateCountForBall(gameNumberOfPlayer, count);
        }
        return count;
    }

    private int updateCountForBall(final int gameNumberOfPlayer, int count) {
        if (!gameNumbersOfComputer.isContains(gameNumberOfPlayer)) {
            count += 1;
        }
        return count;
    }

    private int countStrikes(final GameNumbers gameNumbersOfPlayer) {
        int count = INITIAL_COUNT_VALUE;
        for (int i = 0; i < 3; i++) {
            int gameNumberOfPlayer = gameNumbersOfPlayer.valueAt(i);
            count = updateCountForStrike(gameNumberOfPlayer, i, count);
        }
        return count;
    }

    private int updateCountForStrike(final int gameNumberOfPlayer, final int index, int count) {
        if (gameNumbersOfComputer.isSameValueAt(index, gameNumberOfPlayer)) {
            count += 1;
        }
        return count;
    }

}
