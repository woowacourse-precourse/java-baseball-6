package baseball.dto;

public class GameResult {
    private int ballCount;
    private int strikeCount;

    public GameResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    @Override
    public String toString() {
        return calculateScore();
    }

    private String calculateScore() {
        StringBuilder sb = new StringBuilder();
        if(ballCount != 0) sb.append(ballCount).append("볼");
        if(hasBallAndStrike()) sb.append(" ");
        if(strikeCount != 0) sb.append(strikeCount).append("스트라이크");
        if(!sb.isEmpty()) return sb.toString();
        return "낫싱";
    }

    private boolean hasBallAndStrike() {
        return ballCount != 0 && strikeCount != 0;
    }

    public boolean isThreeStrike() {
        return this.strikeCount == 3;
    }
}
