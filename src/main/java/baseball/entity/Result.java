package baseball.entity;

// Result는 채점 결과를 저장
public class Result {
    private final int strikeNumber;
    private final int ballNumber;

    public Result(int strikeNumber, int ballNumber) {
        this.strikeNumber = strikeNumber;
        this.ballNumber = ballNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        getBall(sb);
        getStrike(sb);
        checkNothing(sb);
        return sb.toString();
    }

    private void checkNothing(StringBuilder sb) {
        if (ballNumber == 0 && strikeNumber == 0) {
            sb.append("낫싱 ");
        }
    }

    private void getStrike(StringBuilder sb) {
        if (strikeNumber != 0) {
            sb.append(strikeNumber).append("스트라이크 ");
        }
    }

    private void getBall(StringBuilder sb) {
        if (ballNumber != 0) {
            sb.append(ballNumber).append("볼 ");
        }
    }

    public boolean isAllCorrect() {
        return strikeNumber == 3;
    }
}
