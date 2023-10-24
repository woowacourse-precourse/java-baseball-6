package baseball.view;

public enum ViewType {
    START("숫자 야구 게임을 시작합니다."),
    ROUND("숫자를 입력해주세요 : "),
    END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    final private String type;

    ViewType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
