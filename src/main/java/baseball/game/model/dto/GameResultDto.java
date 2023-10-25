package baseball.game.model.dto;

public record GameResultDto(
        int ball,
        int strike
) {
    public int getBall(){
        return ball;
    }

    public int getStrike(){
        return strike;
    }
}
