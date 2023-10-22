package baseball;

public class Count {
    private final String number;

    private Count(String number) {
        classInvariant(number);
        this.number = number;
    }

    private void classInvariant(String number) {
        isThreeDigits(number);
    }

    private void isThreeDigits(String number) {
        if (number.length() != 3) {
            throw new IllegalArgumentException("3자리의 정수를 입력해야 합니다.");
        }

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException("3자리의 정수를 입력해야 합니다");
            }
        }
    }

    public static Count provideCount(String number) {
        return new Count(number);
    }

    @Override
    public String toString() {
        return this.number;
    }
}
