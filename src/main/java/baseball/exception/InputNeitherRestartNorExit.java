package baseball.exception;

public class InputNeitherRestartNorExit extends IllegalArgumentException {
    private static final String INPUT_NEITHER_RESTART_NOR_EXIT = "게임 재시작(1) 또는 게임 종료(2) 중 하나를 입력해야 합니다.";

    public InputNeitherRestartNorExit() {
        super(INPUT_NEITHER_RESTART_NOR_EXIT);
    }
}
