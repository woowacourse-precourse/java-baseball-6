package baseball;

public enum ExitCode {
    CON("1"), EXIT("2");
    private String exitCode;

    private ExitCode(String exitCode) {
        this.exitCode = exitCode;
    }

    public String getExitCode() {
        return exitCode;
    }
}
