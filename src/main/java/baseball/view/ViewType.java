package baseball.view;

public enum ViewType {
    START("숫자 야구 게임을 시작합니다.\n"),
    ROUND("숫자를 입력해주세요 : ", "^[\\d]{3}$"),
    END("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n", "^[1-2]{1}$");

    final private String type;
    private String pattern;

    ViewType(String type) {
        this.type = type;
    }

    ViewType(String type, String pattern) {
        this.type = type;
        this.pattern = pattern;
    }

    public String getType() {
        return type;
    }

    public String getPattern() {
        return pattern;
    }
}
