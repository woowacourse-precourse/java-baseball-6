package baseball.service;

public class Illegal {

    BaseBallGameLogic baseBallGameLogic = new BaseBallGameLogic();

    public void checkIllegal(String number) {
        illegalNotThree(number);
        int integerNumber = illegalDigitNumber(number);
        int[] separateNum = illegalDuplicateNumberCheck(integerNumber);
        BaseBallGameLogic.saveInputNumber(separateNum);
    }

    public void illegalNotThree(String num) {
        if (num.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public int illegalDigitNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            int charNumber = number.charAt(i);
            if (!Character.isDigit(charNumber)) {
                //System.out.println("2번오류");
                throw new IllegalArgumentException();

            } else if (charNumber == '0') {
                throw new IllegalArgumentException();
            }
        }
        return Integer.parseInt(number);
    }

    public int[] illegalDuplicateNumberCheck(int number) {
        int[] separateNumber = baseBallGameLogic.arrayNumber(number);
        for (int i = 0; i < separateNumber.length - 1; i++) {
            illegalDuplicateNumberCompare(separateNumber, i, separateNumber.length);
        }
        return separateNumber;
    }

    public void illegalDuplicateNumberCompare(int[] num, int i, int numLength) {
        for (int j = i + 1; j < numLength; j++) {
            if (num[i] == num[j]) {
                //System.out.println("4번오류");
                throw new IllegalArgumentException();
            }
        }
    }
}
