package baseball;

public record Result(int strike, int ball) {

    public boolean isCorrect() {
        return strike == 3;
    }
}
