package baseball.controller;

//입력이 잘못됐을 때 예외처리를 구현
public class Foul {
    public String validateInput(String hitterString) {
        // 입력값의 길이 확인
        if (hitterString == null || hitterString.length() != 3) {
            throw new IllegalArgumentException();
        }

        char[] charArray = hitterString.toCharArray();
        // 입력값이 다 숫자인지 확인
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
            // 입력값에 중복이 없는지 확인
            for (int j = i + 1; j < charArray.length; j++) {
                if (c == charArray[j]) {
                    throw new IllegalArgumentException();
                }
            }
        }
        return hitterString;
    }
}
