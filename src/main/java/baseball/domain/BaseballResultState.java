package baseball.domain;

public enum BaseballResultState {
    STRIKE,
    BALL,
    NOTHING;

    @Override
    public String toString() {
        switch (this) {
            case BALL -> {
                return "볼";
            }
            case STRIKE -> {
                return "스트라이크";
            }
            case NOTHING -> {
                return "낫싱";
            }
            default -> throw new EnumConstantNotPresentException(this.getDeclaringClass(), "not define");
        }

    }
}
