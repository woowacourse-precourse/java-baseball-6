package baseball;

enum OutputMessage {
    START("숫자 야구 게임을 시작합니다."),
    INPUT_NUMBER("숫자를 입력해주세요 : "),
    BALL("볼"),
    STRIKE("스트라이크"),
    GAME_CLEAR("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RETRY_OR_END("게임을 새로 시작하려면 " + Command.RETRY.key + ", 종료하려면 " + Command.EXIT.key + "를 입력하세요.")

    ;
    final String message;

    OutputMessage(String message) {
        this.message = message;
    }
}
