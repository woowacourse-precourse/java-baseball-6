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
            //System.out.println("1번오류");
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
