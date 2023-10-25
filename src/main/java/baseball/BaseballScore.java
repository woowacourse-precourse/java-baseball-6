package baseball;

public class BaseballScore {

    private boolean isNothing;
    private int ballNumber;
    private int strikeNumber;

    public BaseballScore(int ballNumber, int strikeNumber) {
        if (ballNumber < 0 || strikeNumber < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        if (ballNumber + strikeNumber > 3) {
            throw new IllegalArgumentException("3을 넘을 수 없습니다.");
        }

        if (ballNumber == 0 && strikeNumber == 0) {
            isNothing = true;
        } else {
            isNothing = false;
            this.ballNumber = ballNumber;
            this.strikeNumber = strikeNumber;
        }
    }

    public String getNumberMessage() {
        if (isNothing) {
            return "낫싱";
        } else if (ballNumber == 0) {
            return strikeNumber + "스트라이크";
        } else if (strikeNumber == 0) {
            return ballNumber + "볼";
        } else {
            return ballNumber + "볼 " + strikeNumber + "스트라이크";
        }
    }

    public int getStrike() {
        return strikeNumber;
    }
}
