package baseball.dto;

public class StrikeBallCount {

    // 유저가 고른 수의 Strike와 Ball 갯수
    int strikeCount;
    int ballCount;

    public StrikeBallCount() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void increaseStrikeCount() {
        this.strikeCount++;
    }

    public void increaseBallCount() {
        this.ballCount++;
    }

    public String countPrint() {
        if (this.strikeCount == 0 && this.ballCount == 0) {
            return "낫싱";
        }
        return ballPoint() + strikePrint();
    }

    public String strikePrint() {
        if (this.strikeCount == 0) {
            return "";
        }
        return String.format("%d스트라이크", this.strikeCount);
    }

    public String ballPoint() {
        if (this.ballCount == 0) {
            return "";
        }
        return String.format("%d볼 ", this.ballCount);
    }

}
