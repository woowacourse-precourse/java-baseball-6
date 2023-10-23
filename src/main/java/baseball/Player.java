package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Player {
    private int number;
    private int[] numbers = new int[10];

    private Player() {
        String stringNumber = readLine();

        System.out.println("숫자를 입력해주세요 :" + stringNumber);

        if (isCorrectNumber(stringNumber)) {
            this.number = Integer.parseInt(stringNumber);
        }
    }

    private boolean isCorrectNumber(String stringNumber) {
        positiveNumber(stringNumber);
        oneToNine(stringNumber);
        onlyNumber(stringNumber);
        threeCount(stringNumber);
        distinctNumber(stringNumber);
        return true;
    }

    private void distinctNumber(String stringNumber) {
        for (int i = 0; i < 3; i++) {
            int number = stringNumber.charAt(i) - '0';
            this.numbers[number]++;

            if (this.numbers[number] > 1) {
                throw new IllegalArgumentException("입력하신 숫자는 중복되었습니다.");
            }
        }
    }

    private void positiveNumber(String stringNumber) {
        if (Integer.parseInt(stringNumber) <= 0) {
            throw new IllegalArgumentException("입력하신 숫자는 정수가 아닙니다.");
        }
    }

    private void oneToNine(String stringNumber) {
        if (stringNumber.contains("0")) {
            throw new IllegalArgumentException("입력하신 숫자에 0이 포함되었습니다.");
        }
    }

    private static void onlyNumber(String stringNumber) {
        if (!stringNumber.matches("[1-9]+")) {
            throw new IllegalArgumentException("입력하신 숫자에는 문자가 포함되었습니다.");
        }
    }

    private void threeCount(String stringNumber) {
        if (stringNumber.length() != 3) {
            throw new IllegalArgumentException("입력하신 숫자는 3개가 아닙니다.");
        }
    }

    public static Player nextNumberOf() {
        return new Player();
    }

    public int getNumber() {
        return this.number;
    }
}