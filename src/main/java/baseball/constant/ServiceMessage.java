package baseball.constant;

public enum ServiceMessage {
    START("숫자 야구 게임을 시작합니다.\n"),
    INPUT("숫자를 입력해주세요 : "),
    SUCCESS("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    RETRY("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
    public String serviceMessage;

    ServiceMessage(String serviceMessage) {
        this.serviceMessage = serviceMessage;
    }
}
