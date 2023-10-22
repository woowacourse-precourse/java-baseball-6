package baseball.domain;

public enum GameRules {
    // 1 ~ 9까지의 수를 받는다.
    START(1),
    END(9),
    // 3개의 숫자를 입력받는다.
    INPUT_LIMIT(3);
    private final int balls;
    GameRules(int balls) {
        this.balls = balls;
    }
    public int getBalls() {
        return balls;
    }
}
