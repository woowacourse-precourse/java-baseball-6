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

    //숫자 개수 확인
    public boolean checkLength(String userString, int length) {
        if (userString.length() == length) {
            return true;
        } else {
            throw new IllegalArgumentException(length + "개의 숫자를 입력해주세요.");
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

    //유저 정답 입력 숫자 확인
    public boolean isOkInput(String userString) {
        return isInteger(userString) && checkLength(userString, 3) && isDistinct(userString);
    } //유저의 인풋을 검사하는 함수

    //재시작 시 입력 숫자 확인
    public boolean isOkRestart(String userString) {
        return isInteger(userString) && checkLength(userString, 1);
    }


}

