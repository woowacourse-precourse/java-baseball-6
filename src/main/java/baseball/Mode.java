package baseball;

public class Mode {
    private int mode;

    public Mode() {
        // TODO: 입력된 Mode 예외 처리

        setMode(Integer.parseInt(Input.readModeRestartOrEnd()));
    }

    private void setMode(int mode) {
        this.mode = mode;
    }

    public boolean isRestart() {
        return this.mode == Constants.MODE_RESTART;
    }
}
