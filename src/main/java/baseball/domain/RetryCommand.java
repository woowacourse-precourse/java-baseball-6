package baseball.domain;

public enum RetryCommand {

    RETRY("1"),
    QUIT("2");

    final String content;

    RetryCommand(String content) {
        this.content = content;
    }

    public boolean isRetry() {
        return this.equals(RETRY);
    }

    public String getNumber() {
        return content;
    }

}
