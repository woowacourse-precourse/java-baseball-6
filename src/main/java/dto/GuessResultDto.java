package dto;

public class GuessResultDto {
    private int ball;
    private int strike;

    public GuessResultDto() {
        this.ball = 0;
        this.strike = 0;
    }
    public GuessResultDto(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() { return this.ball; }
    public int getStrike() { return this.strike; }

    public void setBall(int ball) { this.ball = ball; }
    public void setStrike(int strike) { this.strike = strike; }
}
