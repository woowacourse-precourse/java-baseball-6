package baseball;

// 볼, 스트라이크 갯수가 자주 필요하여 따로 뺌
public record BallStrike(int ball, int strike) {

    public boolean isCorrect() {
        return strike == 3;
    }
}
