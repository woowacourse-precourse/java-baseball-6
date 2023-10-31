package baseball;

public class Mode {
    private final int mode;

    public Mode() {
        String mode = Input.readModeRestartOrEnd();
        validateInput(mode);

        this.mode = Integer.parseInt(mode);
    }

    private void validateInput(String mode) {
        isNumber(mode);
        isRestartOrEnd(mode);
    }

    public int getMode() {
        return this.mode;
    }

    public boolean isRestart(int mode) {
        return mode == Constants.MODE_RESTART;
    }

    private boolean isEnd(int mode) {
        return mode == Constants.MODE_END;
    }

    private void isNumber(String mode) {
        try {
            Integer.parseInt(mode);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자 이외의 문자가 포함된 값을 입력했습니다.");
        }
    }

    private void isRestartOrEnd(String modeStr) throws IllegalArgumentException {
        int mode = Integer.parseInt(modeStr);
        if (!(isRestart(mode) || isEnd(mode))) {
            throw new IllegalArgumentException("1 또는 2가 아닌 값을 입력했습니다.");
        }
    }
}
