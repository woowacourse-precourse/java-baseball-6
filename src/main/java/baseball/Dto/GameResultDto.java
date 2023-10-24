package baseball.Dto;

public class GameResultDto {
    private int strikes;
    private int balls;

    public GameResultDto(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public int getStrikes() {
        return strikes;
    }


    public int getBalls() {
        return balls;
    }

}
