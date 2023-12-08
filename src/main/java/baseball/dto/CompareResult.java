package baseball.dto;

public record CompareResult(int strike, int ball) {

    public boolean isThreeStrike() {
        return strike == 3;
    }
}
