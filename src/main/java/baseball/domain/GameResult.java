package baseball.domain;

public class GameResult {
    private int strikeCount;
    private int ballCount;

    public GameResult() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public final static String NOT_THING = "낫싱";
    public final static String BALL_AND_STRIKE = "%d볼 %d스트라이크\n";


    @Override
    public String toString() {
        String result = "";
        if (ballCount == 0 && strikeCount == 0) {
            result = NOT_THING;
        } else if (ballCount > 0 || strikeCount > 0) {
            result = String.format(BALL_AND_STRIKE, ballCount, strikeCount);
        }

        return result;
    }

    public void updateResult(int playerNumber, int computerNumber, Computer computer) {
        if (playerNumber == computerNumber) {
            this.addStrikeCount();
            return;
        }
        if (computer.contains(playerNumber)) {
            this.addBallCount();
        }
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void addStrikeCount() {
        strikeCount++;
    }

    public void addBallCount() {
        ballCount++;
    }
}
