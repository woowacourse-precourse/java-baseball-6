package baseball.controller;

import baseball.model.Number;

public class Illegal {

    public void checkIllegal(String num) {
        int integerNumber = parseIntNumber(num);
        illegalNotThree(integerNumber);
        int[] separateNum = illegalIncludeZero(integerNumber);
        illegalDuplicateNumberCheck(separateNum);
        saveInputNumber(separateNum);
    }

    public int parseIntNumber(String num) throws IllegalArgumentException {
        int intNum;
        try {
            intNum = Integer.parseInt(num);
        } catch (Exception e) {
            // TODO: handle exception
            throw new IllegalArgumentException("숫자 이외의 수를 입력하였습니다.");
        }
        return intNum;
    }

    public void illegalNotThree(int num) throws IllegalArgumentException {
        if (num < 100 || num >= 1000) {
            throw new IllegalArgumentException("세자리 수가 아닌 수를 입력하였습니다.");
        }
    }

    public int[] illegalIncludeZero(int num) throws IllegalArgumentException {
        int[] sepNum = new int[3];
        int div = 100;
        for (int i = 0; i < sepNum.length; i++) {
            sepNum[i] = num / div;
            if (sepNum[i] == 0) {
                throw new IllegalArgumentException("0을 포함한 숫자를 입력하였습니다.");
            }
            num -= sepNum[i] * div;
            div /= 10;
        }
        return sepNum;
    }

    public void illegalDuplicateNumberCheck(int[] num) {
        for (int i = 0; i < num.length - 1; i++) {
            illegalDuplicateNumberCompare(num, i, num.length);
        }
    }

    public void illegalDuplicateNumberCompare(int[] num, int i, int numLength) throws IllegalArgumentException {
        for (int j = i + 1; j < numLength; j++) {
            if (num[i] == num[j]) {
                throw new IllegalArgumentException("중복된 숫자를 입력하였습니다.");
            }
        }
    }

    public void saveInputNumber(int[] num) {
        Number number = new Number();
        number.setUserNumber(num);
    }

    public boolean gameStopCheckInputNumber(int strikeCount) {

        return strikeCount < 3;
    }
}
