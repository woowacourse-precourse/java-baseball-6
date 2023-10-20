package baseball.service;

/**
 * 3. validate() : 사용자의 잘못된 값을 입력했는지 validation
 */
public class UserValidation {
    public int validation(String userInputString) {
        // 입력 길이 검증
        if (userInputString.length() != 3) {
            throw new IllegalArgumentException("Fail : 세자리 숫자를 입력해주세요.");
        }

        // 중복 문자 검증
        if (!hasAllUniqueCharacters(userInputString)) {
            throw new IllegalArgumentException("Fail : 중복된 숫자를 입력하셨습니다.");
        }

        // 숫자 변환 및 범위 검증
        int userInput = parseAndValidateNumber(userInputString);

        return userInput;
    }

    private boolean hasAllUniqueCharacters(String str) {
        return str.chars().distinct().count() == str.length();
    }

    private int parseAndValidateNumber(String str) {
        try {
            int number = Integer.parseInt(str);
            if (number < 100 || number > 999) {
                throw new IllegalArgumentException("Fail : 3 자리 숫자를 입력해주세요.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Fail : 1~9 사이 숫자를 입력해주세요");
        }
    }


    public int restartValid(String restart) {
        // 숫자가 아니거나 1 or 2가 아니라면 IllegalArgumentException()
        try {
            int userRestart = Integer.parseInt(restart);

            if (userRestart == 1 || userRestart == 2) {
                return userRestart;
            }
        } catch (NumberFormatException e) {
        }
        throw new IllegalArgumentException("Fail : '1 또는 2' 입력해주세요.");
    }
}
