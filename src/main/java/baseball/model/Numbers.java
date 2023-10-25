package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Numbers {
    private int[] numbers;

    public void generateRandomNumbers(int numberLength) {
        this.numbers = new int[numberLength];
        do {
            for (int i = 0; i < numberLength; i++) {
                this.numbers[i] = Randoms.pickNumberInRange(1, 9);
            }
        } while (duplicateNumber());
    }

    public void generateInputNumbers(int numberLength, String str) {
        if (!isValidStr(numberLength, str)) {
            throw (new IllegalArgumentException());
        }
        this.numbers = stringToIntArray(str);
        if (duplicateNumber()) {
            throw (new IllegalArgumentException());
        }
    }

    private boolean duplicateNumber() {
        for (int num = 1; num <= 9; num++) {
            if (countNum(num) > 1) {
                return true;
            }
        }
        return false;
    }

    private int countNum(int num) {
        int cnt;

        cnt = 0;
        for (int n : this.numbers) {
            if (n == num) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean isValidStr(int numberLength, String str) {
        return (isNumberLength(numberLength, str)
                && isInRange(str));
    }

    private boolean isNumberLength(int numberLength, String str) {
        return (str.length() == numberLength);
    }

    private boolean isInRange(String str) {
        for (char ch : str.toCharArray()) {
            if (!('1' <= ch && ch <= '9')) {
                return false;
            }
        }
        return true;
    }

    private static int[] stringToIntArray(String str) {
        int[] arr;

        arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - '0';
        }
        return arr;
    }

    public int countStrike(Numbers answer) {
        int strike;

        strike = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == answer.numbers[i]) {
                strike++;
            }
        }
        return strike;
    }

    public int countFull(Numbers answer) {
        int full;

        full = 0;
        for (int num : numbers) {
            if (isInArray(num, answer)) {
                full++;
            }
        }
        return full;
    }

    private static boolean isInArray(int num, Numbers answer) {
        for (int n : answer.numbers) {
            if (n == num) {
                return true;
            }
        }
        return false;
    }
}
