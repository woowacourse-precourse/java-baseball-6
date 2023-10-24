package baseball.model;

import java.util.Objects;

public class AgainGameNumber {
    private final String againNumber;

    public AgainGameNumber(String againNumber) {
        AgainNumberCheck(againNumber);
        this.againNumber = againNumber;
    }

    public String getAgainNumber() {
        return againNumber;
    }

    public boolean AgainOrNot(String number) {
        return Objects.equals(number, "1");
    }

    public void AgainNumberCheck(String number) throws IllegalArgumentException {
        if (!(number.equals("1") || number.equals("2"))) {
            throw new IllegalArgumentException("1 또는 2가 아닙니다.");
        }
    }
}
