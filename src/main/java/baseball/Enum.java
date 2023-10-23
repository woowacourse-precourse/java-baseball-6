package baseball;

public enum Enum {

    GAME_START("숫자 야구 게임을 시작합니다."),
    INPUT_NUMBER("숫자를 입력해주세요 : "),
    CORRECT_AND_END_THE_GAME("3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크"),
    NUMBER("123456789"),
    INVALID_ANSWER("1 또는 2만 입력할 수 있습니다."),
    NEW_GAME_OR_END("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    END_PROGRAM("프로그램이 완전히 종료되었습니다. 게임을 하고 싶으면 다시실행 해주세요.");

    private String message;

    Enum(String message) {
        this.message = message;
    }
}