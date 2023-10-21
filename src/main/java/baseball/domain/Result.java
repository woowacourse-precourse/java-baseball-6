package baseball.domain;

public class Result {
    private int ballCount;
    private int strikeCount;

    public void initResult() {
        ballCount = 0;
        strikeCount = 0;
    }

    public void addBall() {
        ballCount++;
    }

    public void addStrike() {
        strikeCount++;
    }

    public boolean isNothing() {
        return ballCount == 0 && strikeCount == 0;
    }

    public String getResultStringFormat() {
        if (isAllStrike()) {
            return "3스트라이크";
        } else if (isNothing()) {
            return "낫싱";
        }
        return String.format("%d볼 %d스트라이크%n", ballCount, strikeCount);
    }

    public boolean isAllStrike() {
        return strikeCount == 3;
    }
}
