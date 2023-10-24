package baseball.view;

import baseball.view.exception.DuplicatedInputException;
import baseball.view.exception.NotIntegerInputException;
import baseball.view.exception.NotValidResumeInputException;
import baseball.view.exception.OutOfLengthInputException;
import baseball.view.exception.UsingZeroInputException;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputView {

    public String getUserNumber() {
        String inputString = removeBlank(Console.readLine()).trim();
        checkInputFormat(inputString);
        return inputString;
    }

    public String getResumeOption() {
        String inputString = removeBlank(Console.readLine()).trim();
        checkResumeInputFormat(inputString);
        return inputString;
    }

    public void checkInputFormat(String inputString) throws IllegalArgumentException {
        validateIntegerInput(inputString);
        validateIntegerLength(inputString, 3);
        validateNotZero(inputString);
        validateDuplicatedNumber(inputString);
    }

    public void checkResumeInputFormat(String inputString) throws IllegalArgumentException {
        validateIntegerInput(inputString);
        validateIntegerLength(inputString, 1);
        validateResumeFormat(inputString);
    }

    private void validateNotZero(String inputString) throws UsingZeroInputException {
        if (isZeroIncluded(inputString)) {
            throw new UsingZeroInputException(inputString);
        }

    }

    private void validateResumeFormat(String inputString) throws NotValidResumeInputException {
        if (!inputString.equals("1") && !inputString.equals("2")) {
            throw new NotValidResumeInputException(inputString);
        }
    }

    private void validateIntegerInput(String inputString) throws NotIntegerInputException {
        if (!isInteger(inputString)) {
            throw new NotIntegerInputException(inputString);
        }
    }

    private void validateIntegerLength(String inputString, int N) throws OutOfLengthInputException {
        if (!isLengthSameAsN(inputString, N)) {
            throw new OutOfLengthInputException(inputString, N);
        }
    }

    private void validateDuplicatedNumber(String inputString) throws DuplicatedInputException {
        if (isDuplicated(inputString)) {
            throw new DuplicatedInputException(inputString);
        }
    }

    private boolean isZeroIncluded(String inputString) {
        String[] array = inputString.split("");
        for (String x : array) {
            if (x.equals("0")) {
                return true;
            }
        }
        return false;
    }


    private boolean isInteger(String inputString) {
        try {
            Integer.parseInt(inputString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isLengthSameAsN(String inputString, int N) {
        return inputString.length() == N;
    }

    private boolean isDuplicated(String inputString) {
        String[] array = inputString.split("");
        Set<String> set = new HashSet<>(Arrays.asList(array));
        return set.size() != array.length;
    }

    private String removeBlank(String input) {
        return input.replaceAll("\\s+", "").trim();
    }

}
