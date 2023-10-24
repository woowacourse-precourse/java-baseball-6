package baseball.global.enums;

public enum GuideMessage {

    START_MENU("숫자 야구 게임을 시작합니다."),
    RESTART_MENU("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    INPUT_COMMAND("숫자를 입력해주세요 : "),
    FINISH_GUIDE("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    public final String message;

    GuideMessage(String message) {
        this.message = message;
    }
}
