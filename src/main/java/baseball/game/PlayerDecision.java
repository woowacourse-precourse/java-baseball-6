package baseball.game;

/**
 * PlayerDecision 게임 종료 후의 재시작, 완전 종료를 정하는 플레이어의 결정
 */
public enum PlayerDecision {
    RESTART(1), FINISH(2);

    private final int sign;

    public static final String DECISION_GUIDE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String INVALID_DECISION_MESSAGE = "해당 입력은 1 또는 2만 가능합니다.";

    PlayerDecision(int sign) {
        this.sign = sign;
    }

    public static PlayerDecision of(int intParameter) {
        return switch (intParameter) {
            case 1 -> RESTART;
            case 2 -> FINISH;

            default -> throw new IllegalArgumentException(INVALID_DECISION_MESSAGE);
        };
    }

}
