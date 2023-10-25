package baseball.domain.result;

public record Result(int strike, int ball) {

    public boolean isComplete() {
        return this.strike == 3;
    }
}
