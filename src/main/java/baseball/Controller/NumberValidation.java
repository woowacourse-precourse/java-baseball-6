package baseball.Controller;

/*
판단 메소드 생성
# 1~9 사이의 숫자 사용
=> 반복문을 사용하여 숫자 비교
# 3자리수
=> 길이 비교
# 중복되지 않은 수 사용
=> 반복문을 통해 비교
 */

public class NumberValidation {

    public int[] validationNumber(String inputNumber) {
        if (!checkBetween1to9(inputNumber)) {
            throw new IllegalArgumentException("1~9 사이의 수만 입력이 가능합니다.");
        } else if (!threeDigit(inputNumber)) {
            throw new IllegalArgumentException("3자리의 수를 입력해야 합니다.");
        } else if (!checkDuplication(inputNumber)) {
            throw new IllegalArgumentException("중복된 수를 사용할 수 없습니다.");
        }

        return toInputNumber(inputNumber);
    }

    public int[] toInputNumber(String inputNumber) {
        String cvt[] = inputNumber.split("");
        int strToInt[] = new int[cvt.length];
        for (int i = 0; i < cvt.length; i++) {
            strToInt[i] = Integer.parseInt(cvt[i]);
        }
        return strToInt;
    }


    private boolean between1to9(char checkNum) {
        return checkNum >= '1' && checkNum <= '9';
    }

    public boolean threeDigit(String inputNumber) {
        return inputNumber.length() == 3;
    }

    public boolean checkDuplication(String inputNumber) {
        String[] number = inputNumber.split("");

        for (int i = 0; i < inputNumber.length(); i++) {
            for (int j = 0; j < inputNumber.length(); j++) {
                if (number[i] == number[j]) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean checkBetween1to9(String inputNumber) {
        for (int i = 0; i < inputNumber.length(); i++) {
            if (!between1to9(inputNumber.charAt(i))) {
                return false;
            }
        }
        return true;
    }


}
