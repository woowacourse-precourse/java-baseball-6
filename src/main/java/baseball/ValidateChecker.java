package baseball;

public class ValidateChecker {

    Exception exception = new Exception();

    int count(String input, char target) {
        int countNum;

        countNum = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == target)
                countNum++;
        }
        return (countNum);
    }

    void isUserInputValidate(String userInput) {
        if (userInput.length() > 3 || userInput.length() < 3) {
            exception.generateInvalidAnswerLengthException();
        }
        for (int i = 0; i < 3; i++) {
            if (!(userInput.charAt(i) >= '1' && userInput.charAt(i) <= '9'))
                exception.generateInvalidAnswerRangeException();
        }
        for (int i = 0; i < 3; i++) {
            if (count(userInput, userInput.charAt(i)) > 1) {
                exception.generateInvalidAnswerDuplicateException();
            }
        }
    }

    void isRetryInputValidate(String retryInput) {
        if (retryInput.length() > 1 || retryInput.length() < 1)
            exception.generateInvalidRetryInputLengthException();
        if (retryInput.charAt(0) == '1' || retryInput.charAt(0) == '2')
            exception.generateInvalidAnswerRangeException();
    }
}
