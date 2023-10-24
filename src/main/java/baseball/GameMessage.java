package baseball;

public enum GameMessage {
    GAME_START("숫자 야구 게임을 시작합니다."),
    INPUT_NUMBER("숫자를 입력해주세요 : "),
    WRONG_INPUT("잘못된 값을 입력하였습니다. 게임 종료"),
    SUCCESS_ROUND("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    CONTINUE_ROUND("게임을 새로 시작하려면 " + NextRoundResponse.YES.getResponseNumber() + ", 종료하려면 " + NextRoundResponse.NO.getResponseNumber() + "를 입력하세요."),
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");
    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
