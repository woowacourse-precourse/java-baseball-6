package baseball.models;

public class Score {
    private int strikes;
    private int balls;

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

    public void setScore(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public Score() {
        this.strikes = 0;
        this.balls = 0;
    }
}

// 스트라이크 수, 볼의 수