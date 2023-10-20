package baseball.dto;

public record GameResult(int strike, int ball) {

    public boolean isClear() {
        return strike == 3;
    }
}
