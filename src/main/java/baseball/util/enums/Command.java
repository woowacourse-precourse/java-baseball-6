package baseball.util.enums;

public enum Command {
    START_GAME("숫자 야구 게임을 시작합니다.\n"),
    PITCHING("숫자를 입력해주세요 : "),
    END_GAME("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    ASK_RESUME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n")
    ;
    private final String command;

    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
