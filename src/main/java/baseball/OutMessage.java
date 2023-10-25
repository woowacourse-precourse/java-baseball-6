package baseball;

public enum OutMessage {
    START("숫자 야구 게임을 시작합니다.\n"),
    GUESS("숫자를 입력해주세요 : "),
    ANSWER("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    STOP("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");

    private final String msg;

    OutMessage(String msg) {
        this.msg = msg;
    }

    public void printMsg() {
        System.out.print(msg);
    }

}