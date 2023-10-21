package baseball;

public enum OutputStatement {
    GAME_START_OUTPUT("숫자 야구 게임을 시작합니다."),
    INPUT_NUMBER_OUTPUT("숫자를 입력해주세요 : "),
    GAME_END_OUTPUT("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_OUTPUT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String output;

    OutputStatement(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
}
