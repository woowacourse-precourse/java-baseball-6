package baseball.service;

/**
 * 3. validate() : 사용자의 잘못된 값을 입력했는지 validation
 */
public class UserValidation {
    public int validation(String userInputString) {

        // 입력된 값이 서로 다른 값인지 검증
        char first = userInputString.charAt(0);
        char second = userInputString.charAt(1);
        char third = userInputString.charAt(2);

        if ((first != second) && (first != third) && (second != third)) {
            int userInput;
            // 숫자가 입력됐는지 검증

            try {
                userInput = Integer.parseInt(userInputString);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }

            // 100~999 사이 숫자인지 검증
            if (!(userInput > 99 && userInput < 1000)) {
                throw new IllegalArgumentException();
            }
            return userInput;
        }

        throw new IllegalArgumentException();
    }

    public int restartValid(String restart) {
        int userRestart;
        // 숫자가 아니거나 1 or 2가 아니라면 IllegalArgumentException()
        try {
            userRestart = Integer.parseInt(restart);
            if (userRestart != 1 && userRestart != 2) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return userRestart;
    }
}
