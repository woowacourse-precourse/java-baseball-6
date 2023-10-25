package baseball;

public class Player {
    private int number;
    private int[] numbers = new int[10];

    public static Player inputNumberOf(String stringNumber) {
        return new Player(stringNumber);
    }

    private Player() {
    }

    private Player(String stringNumber) {
        System.out.println("숫자를 입력해주세요 :" + stringNumber);

        if (isCorrectNumber(stringNumber)) {
            this.number = Integer.parseInt(stringNumber);
        }
    }

    public int getNumber() {
        return this.number;
    }

    private boolean isCorrectNumber(String stringNumber) {
        validateOnlyNumber(stringNumber);
        validatePositive(stringNumber);
        validateThreeCount(stringNumber);
        validateDistinct(stringNumber);
        return true;
    }

    private static void validateOnlyNumber(String stringNumber) {
        if (!stringNumber.matches("[1-9]+")) {
            throw new IllegalArgumentException("입력하신 내용엔 숫자외 값이 포함되었습니다.");
        }
    }

    private void validatePositive(String stringNumber) {
        if (Integer.parseInt(stringNumber) <= 0) {
            throw new IllegalArgumentException("입력하신 숫자는 정수가 아닙니다.");
        }
    }

    private void validateThreeCount(String stringNumber) {
        if (stringNumber.length() != 3) {
            throw new IllegalArgumentException("입력하신 숫자는 3개가 아닙니다.");
        }
    }

    private void validateDistinct(String stringNumber) {
        for (int i = 0; i < 3; i++) {
            int number = stringNumber.charAt(i) - '0';
            this.numbers[number]++;

            if (this.numbers[number] > 1) {
                throw new IllegalArgumentException("입력하신 숫자는 중복되었습니다.");
            }
        }
    }
}