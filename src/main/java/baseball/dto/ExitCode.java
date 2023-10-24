package baseball.dto;

public class ExitCode {

    private final Integer number;

    public ExitCode(Integer number) {
        validateNumber(number);
        this.number = number;
    }

    public boolean isExit() {
        return number.equals(2);
    }

    private void validateNumber(Integer number) {
        if (number < 1 || 2 < number) throw new IllegalArgumentException();
    }

}
