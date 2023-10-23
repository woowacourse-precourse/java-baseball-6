package baseball.entity;

public class Player {
    public int number;

    public Player(int number) {
        valid(number);
    }

    public Player(String number) {
        try {
            int intNumber = Integer.parseInt(number);
            valid(intNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private void valid(int number) {
        checkNumberRange(number);
        hasUniqueDigits(number);
        checkDigitOneToNine(number);
        this.number = number;
    }
    private void checkNumberRange(int number) {
        if (!isInRange(number)) {
            throw new IllegalArgumentException("입력 가능한 수 범위는 123 ~ 987 입니다.");
        }
    }

    private boolean isInRange(int number) {
        return number >= 123 && number <= 987;
    }

    private void hasUniqueDigits(int number) {
        String numberString = String.valueOf(number);

        for (int i = 0; i < numberString.length() - 1; i++) {
            for (int j = i + 1; j < numberString.length(); j++) {
                if (numberString.charAt(i) == numberString.charAt(j)) {
                    throw new IllegalArgumentException("서로 다른 수로 이루어져야 합니다.");
                }
            }
        }
    }

    private void checkDigitOneToNine(int number) {
        String numberString = String.valueOf(number);

        for (int i = 0; i < numberString.length() - 1; i++) {
            if (numberString.charAt(i) == '0') {
                throw new IllegalArgumentException("각 자리의 수는 1 ~ 9 로 이루어져야 합니다.");
            }
        }
    }
}
