package baseball.game;

import baseball.NumberFactory;
import baseball.error.ErrorCode;

import java.util.*;
import java.util.stream.Collectors;

public class Game {

    private static final int LIMIT = 3;
    private static final int RESTART_INPUT_LIMIT = 1;

    private final List<Integer> ANSWER_NUMBERS;

    private RecordTable recordTable;

    private int strike;
    private int ball;

    public Game() {
        this.ANSWER_NUMBERS = NumberFactory.createNumbers();
        this.recordTable = new RecordTable();
    }

    public void check(String userInput) {
        valid(userInput);
        List<Integer> userNumbers = convertToIntegerList(userInput);

        resetRecord();
        for (Integer userNumber : userNumbers) {
            if (ANSWER_NUMBERS.contains(userNumber)) {
                checkStrike(userNumber, userNumbers);
            }
        }
    }

    private void checkStrike(Integer userNumber, List<Integer> userNumbers) {
        if (userNumbers.indexOf(userNumber) == ANSWER_NUMBERS.indexOf(userNumber)) {
            strike++;
            return;
        }
        ball++;
    }

    private void resetRecord() {
        strike = 0;
        ball = 0;
    }


    private List<Integer> convertToIntegerList(String userInput) {
        String[] arr = userInput.split("");
        return Arrays.stream(arr).map(Integer::valueOf).collect(Collectors.toList());
    }

    private void valid(String userInput) {
        validateSize(userInput);
        validateDigit(userInput);
        validateDuplication(userInput);
    }

    private static void validateSize(String userInput) {
        if (userInput.length() != GameConfig.SIZE) {
            throw new IllegalArgumentException(ErrorCode.SIZE_ERROR.message);
        }
    }

    private static void validateDigit(String userInput) {
        for (char target : userInput.toCharArray()) {
            if (!Character.isDigit(target)) {
                throw new IllegalArgumentException(ErrorCode.DIGIT_ERROR.message);
            }
        }
    }

    private static void validateDuplication(String userInput) {
        Set<Character> temp = new HashSet<>();

        for (char userNumber : userInput.toCharArray()) {
            temp.add(userNumber);
        }

        if (temp.size() != GameConfig.SIZE) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATION_ERROR.message);
        }
    }
}
