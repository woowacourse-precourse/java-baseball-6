package baseball.domain;

public record ReplayCommand(int number) {
    public ReplayCommand {
        validate(number);
    }

    private void validate(int number) {
        if (number != 1 && number != 2) {
            throw new IllegalArgumentException();
        }
    }

    public boolean shouldReplay() {
        return number == 1;
    }
}
