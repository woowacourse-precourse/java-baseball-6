package baseball.constant;

/**
 * {@summary 프로그램 전반에 사용되는 출력 메세지를 다룬다.}
 */
public enum Message {
    INIT("숫자 야구 게임을 시작합니다."),
    INPUT("숫자를 입력해주세요 : "),
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱"),
    WIN("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RETRY("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String value;

    Message(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }
}
