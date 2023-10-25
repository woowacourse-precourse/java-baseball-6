package baseball.domain.dto;

public record GameResultDTO(int ball, int strike) {
    public boolean isThreeStrikes() {
        return strike == 3;
    }
}

