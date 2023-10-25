package baseball;

public class ValidateChecker {

    Exception exception = new Exception();
    ValidateCheckerUtils validateCheckerUtils = new ValidateCheckerUtils();

    void isUserInputValidate(String userInput) {
        validateCheckerUtils.checkLengthValidate(userInput, 3);
        if (!validateCheckerUtils.isRangeValidate(userInput, '1', '9'))
            exception.generateInvalidAnswerRangeException();
        validateCheckerUtils.checkDuplicateValidate(userInput);
    }

    void isRetryInputValidate(String retryInput) {
        validateCheckerUtils.checkLengthValidate(retryInput, 1);
        if (!validateCheckerUtils.isRangeValidate(retryInput, '1', '2'))
            exception.generateInvalidRetryInputRangeException();
    }
}

class ValidateCheckerUtils {
    Exception exception = new Exception();

    int count(String input, char target) {
        int countNum;

        countNum = 0;
        for (int userInputIndex = 0; userInputIndex < input.length(); userInputIndex++) {
            if (input.charAt(userInputIndex) == target) {
                countNum++;
            }
        }
        return (countNum);
    }

    void checkLengthValidate(String userInput, int length) {
        if (userInput.length() != length) {
            if (length == 3) {
                exception.generateInvalidAnswerLengthException();
            }
            if (length == 1) {
                exception.generateInvalidRetryInputLengthException();
            }
        }
    }

    boolean isRangeValidate(String userInput, char start, char end) {
        for (int userInputIndex = 0; userInputIndex < userInput.length(); userInputIndex++) {
            if (userInput.charAt(userInputIndex) < start || userInput.charAt(userInputIndex) > end) {
                return (false);
            }
        }
        return (true);
    }

    void checkDuplicateValidate(String userInput) {
        for (int userInputIndex = 0; userInputIndex < userInput.length(); userInputIndex++) {
            if (count(userInput, userInput.charAt(userInputIndex)) > 1) {
                exception.generateInvalidAnswerDuplicateException();
            }
        }
    }
}
