package baseball.domain.game;

public enum GameInfo {
    GAME_START("숫자 야구 게임을 시작합니다."),
    ENTER_NUMBER("숫자를 입력해주세요 : "),
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    GAME_OVER("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    END_OR_RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");


    private final String info;

    GameInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
