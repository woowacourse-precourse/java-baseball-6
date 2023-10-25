package baseball.model.constants;

public enum Phrase {
    GAME_START_PHRASE("숫자 야구 게임을 시작합니다."),
    GAME_INPUT_PHRASE("숫자를 입력해주세요 : "),
    GAME_CLEAR_PHRASE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    GAME_RESTART_PHRASE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),

    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    private final String phrase;

    Phrase(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }
}