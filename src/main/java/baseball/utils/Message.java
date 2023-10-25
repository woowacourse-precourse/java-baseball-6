package baseball.utils;

public enum Message {
    START_GAME_MESSAGE("숫자 야구 게임을 시작합니다."),
    GET_PLAYER_INPUT("숫자를 입력해주세요 : "),
    PRINT_NOTHING("낫싱"),
    PRINT_BALL("볼 "),
    PRINT_STRIKE("스트라이크"),
    WIN_GAME("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_GAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message; //필드값 추가

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    } // 열거형 메소드

}
