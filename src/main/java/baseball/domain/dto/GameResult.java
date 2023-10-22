package baseball.domain.dto;

public record GameResult(int ball, int strike) {
    public boolean isThreeStrikes() {
        return strike == 3;
    }
}

