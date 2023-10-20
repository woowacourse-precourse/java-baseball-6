package baseball;

public enum ConstantView {

    START("숫자 야구 게임을 시작합니다.\n"),
    INPUT("숫자를 입력해주세요 : "),
    RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"),
    END("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTING("낫싱");

    private final String message;
    public String getMessage(){
        return message;
    }
    ConstantView(String message) {
        this.message= message;
    }
}
