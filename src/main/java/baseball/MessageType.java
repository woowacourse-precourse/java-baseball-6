package baseball;

public enum MessageType {
    GAME_BEGIN("숫자 야구 게임을 시작합니다."),
    CHOOSE_NEXT_OR_END("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    GAME_EXIT("게임을 종료합니다."),
    INPUT_USER_NUM("1 ~ 9 사이의 숫자를 3개 입력해주세요 : ")
    ;

    private final String messageDetail;
    MessageType(String messageDetail) {
        this.messageDetail = messageDetail;
    }
    public String getMessageDetail() {
        return messageDetail;
    }
}
