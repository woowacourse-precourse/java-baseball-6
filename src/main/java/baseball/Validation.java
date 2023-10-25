package baseball;

import java.util.HashSet;

import static java.lang.Integer.parseInt;

public class Validation {
    public int isValidateNumber(String userInput){
        int inputNumber;

        // Integer.parseInt가 되지 않는 경우
        try {
            inputNumber = parseInt(userInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("정수가 아닌 문자열입니다.");
        }

        // 3자리 숫자가 아닌 경우 예외 발생
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }

        // 사용자의 입력에 0이 포함된 경우 예외 발생
        if (userInput.contains("0")) {
            throw new IllegalArgumentException("0이 포함되어 있으면 안됩니다.");
        }

        // 사용자의 입력에 중복된 숫자가 포함된 경우 예외 발생
        if (isDuplicate(userInput)) {
            throw new IllegalArgumentException("중복된 숫자가 포함되어 있으면 안됩니다.");
        }

        return inputNumber;
    }

    /**
     * 사용자가 입력한 문자열 안에 중복된 숫자가 있는지 검사한다.
     * set은 중복을 허용하지 않기 때문에 중복된 숫자가 있다면,
     * 처음 입력받은 userInput과 charSet의 길이가 다를 것이다.
     * @param userInput
     * @return charSet.size() != userInput.length()
     */
    private static boolean isDuplicate(String userInput) {
        HashSet<Character> charSet = new HashSet<>();
        for (int i = 0; i < userInput.length(); i++) {
            charSet.add(userInput.charAt(i));
        }
        return charSet.size() != userInput.length();    // 길이가 달라야 중복인 것.
    }
}
