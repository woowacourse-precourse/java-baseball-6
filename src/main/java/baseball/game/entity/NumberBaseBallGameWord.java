package baseball.game.entity;

public enum NumberBaseBallGameWord {
    START("숫자 야구 게임을 시작합니다."),
    END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    CONTINUE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    RUNNING("숫자를 입력해주세요 : "),
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String krName;

    NumberBaseBallGameWord(String krName) {
        this.krName = krName;
    }

    public String getKrName() {
        return krName;
    }
}
