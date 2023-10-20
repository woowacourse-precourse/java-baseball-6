package baseball.model;

public class ResetGameNumber {
    private final String resetNumber;

    public String getResetNumber() {
        return resetNumber;
    }

    public ResetGameNumber(String number) {
        isCorrectNumber(number);
        this.resetNumber = number;
    }

    public static void isCorrectNumber(String number) {
        if (!number.equals("1") && !number.equals("2")) {
            throw new IllegalArgumentException("1, 2가 아닌 다른 값을 입력했습니다.");
        }
    }
}
