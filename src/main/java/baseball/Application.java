package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    private final static int NUMBER_SIZE = 3;
    private final static int MIN_RANGE_NUM = 1;
    private final static int MAX_RANGE_NUM = 9;

    public static void main(String[] args) {
        PrintMessage printMessage = new PrintMessage();
        printMessage.printGameStartMessage();

        AnswerNumberGenerator answerNumberGenerator = new AnswerNumberGenerator();
        List<Integer> answerNumberList = answerNumberGenerator.getAnswerNumberList();

        printMessage.printReadNumberMessage();
        String userInputNumber = Console.readLine();
        try {
            validateUserInputNumber(userInputNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

    }

    public static void validateUserInputNumber(String userInputNumber)
        throws IllegalArgumentException {
        if (userInputNumber.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException("세자리 수를 입력해주세요.");
        }
        if (!ensureRange(userInputNumber, MIN_RANGE_NUM, MAX_RANGE_NUM)) {
            throw new IllegalArgumentException("1과 9 사이의 숫자를 입력해주세요.");
        }
        if (existsDuplicateNumber(userInputNumber)) {
            throw new IllegalArgumentException("중복이 없는 숫자를 입력해주세요.");
        }
    }

    public static boolean ensureRange(String userInputNumber, int min, int max) {
        for (char digit : userInputNumber.toCharArray()) {
            int numericValue = Character.getNumericValue(digit);
            if (numericValue < min || numericValue > max) {
                return false;
            }
        }
        return true;
    }

    public static boolean existsDuplicateNumber(String userInputNumber) {
        for (char digit : userInputNumber.toCharArray()) {
            if (userInputNumber.chars().filter(c -> c == digit).count() != 1) {
                return true;
            }
        }
        return false;
    }
}