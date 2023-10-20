package baseball.dto;

public class Score {
    private int ball;
    private int strike;
    private GameStatus status;

    public Score() {
        status = GameStatus.PLAY;
    }

    public static Score getInstance(int ball, int strike) {
        Score score = new Score();
        score.ball = ball;
        score.strike = strike;
        if (strike == 3) {
            score.status = GameStatus.END;
        } else {
            score.status = GameStatus.PLAY;
        }
        return score;
    }

    public GameStatus getStatus() {
        return status;
    }

    public String getScoreToString() {
        StringBuilder sb = new StringBuilder();
        if (ball == 0 && strike == 0) {
            sb.append("낫싱");
        } else {
            if (ball > 0) {
                sb.append(String.format("%d볼 ", ball));
            }
            if (strike > 0) {
                sb.append(String.format("%d스트라이크", strike));
            }
        }
        sb.append("\n");
        return sb.toString();
    }
}
