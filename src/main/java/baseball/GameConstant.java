package baseball;

public enum GameConstant {
    STARTING_STRING("숫자 야구 게임을 시작합니다."),
    RESTARING_STRING("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    ENDING_STRING("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    INPUT_STRING("숫자를 입력해주세요 : "),
    STRIKE("스트라이크"),
    BALL("볼 "),
    NOTHING("낫싱"),
    RESTART("1"),
    END("2"),
    SIZE(3),
    RANDOM_START(1),
    RANDOM_END(9);

    private final Object value;

    GameConstant(Object value) {
        this.value = value;
    }

    public String getStringValue() {
        return (String) value;
    }

    public int getIntValue() {
        return (int) value;
    }
}
