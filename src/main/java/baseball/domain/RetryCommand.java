package baseball.domain;

public enum RetryCommand {

    RETRY("1"),
    QUIT("2");

    final String number;

    RetryCommand(String number) {
        this.number = number;
    }

    public boolean isRetry() {
        return this.equals(RETRY);
    }

    public String getNumber() {
        return number;
    }

}
