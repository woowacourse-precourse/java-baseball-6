package baseball.model.dto;

public class Score {
    int strike;
    int ball;
    boolean isGameEnd = false;

    public Score(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
        if(strike == 3) {
            isGameEnd = true;
        }
    }

    public boolean isGameEnd() {
        return isGameEnd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(strike != 0) {
            sb.append(strike).append("스트라이크 ");
        }
        if (ball != 0) {
            sb.append(ball).append("볼");
        }
        if(sb.isEmpty()) {
            sb.append("낫싱");
        }
        sb.append("\n");
        return sb.toString();
    }
}
