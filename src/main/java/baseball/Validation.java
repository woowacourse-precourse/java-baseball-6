package baseball;

public class Validation {

    //숫자인지 확인
    public boolean isInteger(String userString) {
        try {
            Integer.parseInt(userString);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
        return true;
    }

    //숫자가 3개인지 확인
    public boolean isThree(String userString) {
        if (userString.length() == 3) {
            return true;
        } else {
            throw new IllegalArgumentException("3개의 숫자를 입력해주세요.");
        }
    }

    //중복 숫자 존재 여부 확인
    public boolean isDistinct(String userString) {
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (userString.charAt(i) == userString.charAt(j)) {
                    throw new IllegalArgumentException("각각 다른 숫자를 입력해주세요.");
                }
            }
        }
        return true;
    }

    //최종 확인
    public boolean isOk(String userString) {
        if (isInteger(userString) && isThree(userString) && isDistinct(userString)) {
            return true;
        } else {
            return false;
        }

    }
}

