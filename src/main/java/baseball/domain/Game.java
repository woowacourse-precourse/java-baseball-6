package baseball.domain;

public class Game {
    private final int[] answer;
    private int strike;
    private int ball;

    public Game(int[] answer) { this.answer = answer; }

    public void initScore() {
        this.strike = 0;
        this.ball = 0;
    }

    public int[] getAnswer() {return answer; }
    public int getBall() {
        return ball;
    }
    public int getStrike() {
        return strike;
    }
    public void increaseBall() {
        this.ball += 1;
    }
    public void increaseStrike() {
        this.strike += 1;
    }
}
