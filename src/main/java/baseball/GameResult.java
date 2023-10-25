package baseball;

public record GameResult(int strike, int ball) {

    public String getResultString() {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(ball).append("볼 ");
        }
        if (strike > 0) {
            sb.append(strike).append("스트라이크");
        }
        return sb.toString();
    }
}