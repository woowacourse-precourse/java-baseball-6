package baseball;

public enum Message {
    INPUT_USERNUMBER_MESSAGE("숫자를 입력해 주세요 : "),
    STRIKE_MESSAGE("스트라이크"),
    BALL_MESSAGE("볼 "),
    NOTHING_MESSAGE("낫싱"),
    CORRECT_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_QUESTION_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    ;


    private final String message;
    Message(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}