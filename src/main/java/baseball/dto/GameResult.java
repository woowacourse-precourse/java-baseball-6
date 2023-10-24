package baseball.dto;

public record GameResult(int strike, int ball) {
    public boolean isLoop() {
        return strike != 3;
    }
}
