package baseball.controller;

public class Illegal {

    public void checkIllegal(String num) {
        illegalNotThree(num);
        int integerNumber = parseIntNumber(num);
        int[] separateNum = illegalIncludeZero(integerNumber);
        illegalDuplicateNumberCheck(separateNum);
        BaseBallGameLogic.saveInputNumber(separateNum);
    }

    public int parseIntNumber(String num) {
        for (int i = 0; i < num.length(); i++) {
            int number = num.charAt(i);
            if (!Character.isDigit(number)) {
                throw new IllegalArgumentException();
            }
        }
        return Integer.parseInt(num);
    }

    public void illegalNotThree(String num) {
        if (num.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public int[] illegalIncludeZero(int num) {
        int[] sepNum = new int[3];
        int div = 100;
        for (int i = 0; i < sepNum.length; i++) {
            sepNum[i] = num / div;
            if (sepNum[i] == 0) {
                throw new IllegalArgumentException();
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

    public void illegalDuplicateNumberCompare(int[] num, int i, int numLength) {
        for (int j = i + 1; j < numLength; j++) {
            if (num[i] == num[j]) {
                throw new IllegalArgumentException();
            }
        }
    }
    /*public void checkIllegal(String playerNumber) {
        checkThreeLength(playerNumber);
        checkIntegerNumber(playerNumber);
        Number number = new Number();
        number.setUserNumber(playerNumber);
    }

    public void checkThreeLength(String playerNumber) {
        if (playerNumber.length() != 3) {
            throw new IllegalArgumentException("3자리수 아닌 수 입력");
        }
    }

    public void checkIntegerNumber(String playerNumber) throws IllegalArgumentException {
        for (int i = 0; i < playerNumber.length(); i++) {
            if (playerNumber.charAt(i) == '0') {
                throw new IllegalArgumentException("0을 입력");
            }
            duplicateNumberCheck(playerNumber);
        }
    }

    public void duplicateNumberCheck(String playerNumber) throws IllegalArgumentException {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < playerNumber.length() - 1; i++) {
            set.add(String.valueOf(playerNumber.charAt(i)));
            if (set.size() != i + 1) {
                throw new IllegalArgumentException("중복된 숫자 입력");
            }
        }
    }

    public int parseIntNumber(String num) throws IllegalArgumentException {
        int intNum;
        try {
            intNum = Integer.parseInt(num);
        } catch (Exception e) {
            // TODO: handle exception
            throw new IllegalArgumentException("숫자가 아닌 값을 입력하였습니다.");
        }
        return intNum;
    }*/
}
