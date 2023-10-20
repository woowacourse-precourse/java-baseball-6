package baseball.model;

public class Comparator {
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 2;
    private static final int PLUS_ZERO = 0;
    private static final int PLUS_ONE = 1;
    private Player player;
    private Computer computer;

    public Comparator(Player player, Computer computer) {
        this.player = player;
        this.computer = computer;
    }

    public Result compare() {
        int strike = 0;
        int ball = 0;
        for (int i = START_INDEX; i <= END_INDEX; i++)  {
            int playerNumber = player.getNumbers().get(i);
            strike += plusStrike(computer.isSameNumberAndDigit(playerNumber, i));
            ball += plusBall(computer.isExistNumberOf(playerNumber));
        }
        ball -= strike;
        return new Result(strike, ball);
    }

    private int plusStrike(boolean plus) {
        if (plus) {
            return PLUS_ONE;
        }
        return PLUS_ZERO;
    }

    private int plusBall(boolean plus) {
        if (plus) {
            return PLUS_ONE;
        }
        return PLUS_ZERO;
    }
}
