package baseball.StringEnums;

public enum TextProperties {
    NOT_THREE_BALL("입력된 숫자가 3글자가 아닙니다"),
    NOT_NUMBER("입력된 글자가 숫자가 아닙니다."),

    GAME_START("숫자 야구 게임을 시작합니다."),

    INPUT_NUMBER("숫자를 입력해주세요 : "),

    ANSWER("3개의 숫자를 모두 맞히셨습니다! "),
    GAME_OVER("게임 종료"),
    RE_START("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    NOT_THING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크"),
    NOT_RANGE("잘못된 범위의 숫자가 존재합니다"),
    DUP_NUMBER("중복된 숫자가 있습니다");
    TextProperties(final String value){
        this.value=value;
    }
    private String value;
    public String getValue() {
        return value;
    }
    @Override
    public String toString(){
        return value;
    }
}
