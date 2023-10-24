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

    void checkLengthValidate(String userInput, int length) {
        if (userInput.length() != length) {
            exception.generateInvalidAnswerLengthException();
        }
    }

    boolean isRangeValidate(String userInput, char start, char end) {
        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) < start || userInput.charAt(i) > end)
                return (false);}
        return (true);
    }

    void checkDuplicateValidate(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (count(userInput, userInput.charAt(i)) > 1)
                exception.generateInvalidAnswerDuplicateException();
        }
    }

    void isUserInputValidate(String userInput) {
        checkLengthValidate(userInput, 3);
        if (!isRangeValidate(userInput, '1', '9'))
                exception.generateInvalidAnswerRangeException();
        checkDuplicateValidate(userInput);
    }

    void isRetryInputValidate(String retryInput) {
        checkLengthValidate(retryInput, 1);
        if (!isRangeValidate(retryInput, '1', '2'))
            exception.generateInvalidAnswerRangeException();
    }
}
