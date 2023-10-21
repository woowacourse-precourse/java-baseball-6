package baseball.model;

import baseball.controller.RandomNumberUtility;

public class BaseballNumbers {
    private static final String IS_NOT_NUMBER = "숫자로 이루어져 있어야 합니다.";
    private static final String SIZE_EXCEPTION = "3개의 숫자로 이루어져야 합니다";
    private static final String IS_NOT_DISTINCT = "서로다른 숫자로 이루어져야 합니다.";
    private static final char ONE = '1';
    private static final char NINE = '9';
    private final String numbers;

    public BaseballNumbers(String numbers) {
        correctSize(numbers);
        isNumber(numbers);
        isDistinct(numbers);
        this.numbers = numbers;
    }
    public static BaseballNumbers computerNumbers() {
        return new BaseballNumbers(RandomNumberUtility.generateRandomNumbers());
    }

    public static BaseballNumbers playerNumbers(String numbers) {
        return new BaseballNumbers(numbers);
    }

    private void isDistinct(String numbers) {
        int[] check = new int[10];
        for (char c : numbers.toCharArray()) {
            if (check[c-ONE] == 1) {
                throw new IllegalArgumentException(IS_NOT_DISTINCT);
            }
            check[c-ONE]++;
        }
    }

    private void correctSize(String num) {
        if (num.length() != 3) {
            throw new IllegalArgumentException(SIZE_EXCEPTION);
        }
    }
    private void isNumber(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            char num = numbers.charAt(i);
            isBetween1And9(num);
        }
    }

    private void isBetween1And9(char num) {
        if (num < ONE || NINE < num) {
            throw new IllegalArgumentException(IS_NOT_NUMBER);
        }
    }

    public int countBall(BaseballNumbers other) {
        int cnt = 0;
        for (int i = 0; i < numbers.length(); i++) {
            if (other.checkBall(numbers, i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public int countStrike(BaseballNumbers other) {
        int cnt = 0;
        for (int i = 0; i < numbers.length(); i++) {
            if (other.checkStrike(numbers, i)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean checkBall(String com, int idx) {
        char p = numbers.charAt(idx);
        char c = com.charAt(idx);
        if (c != p && com.contains(String.valueOf(p))) {
            return true;
        }
        return false;
    }

    private boolean checkStrike(String com, int idx) {
        char p = numbers.charAt(idx);
        char c = com.charAt(idx);
        if (c == p) {
            return true;
        }
        return false;
    }
}
