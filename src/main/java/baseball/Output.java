package baseball;

public class Output {
    private int strikeCount;
    private int ballCount;

    private final StringBuilder outputStr = new StringBuilder();

    public Output() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public void addStrikeCount() {
        this.strikeCount += 1;
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }

    public void addBallCount() {
        this.ballCount += 1;
    }

    public StringBuilder getOutputStr() {

        if (this.strikeCount == 0 && this.ballCount == 0) {
            this.outputStr.append("낫싱");
        }

        if (this.ballCount > 0) {
            outputStr.append(this.ballCount).append("볼");
        }

        if (this.ballCount > 0 && this.strikeCount > 0) {
            outputStr.append(" ");
        }

        if (this.strikeCount > 0) {
            outputStr.append(this.strikeCount).append("스트라이크");
        }

        return this.outputStr;
    }

}
