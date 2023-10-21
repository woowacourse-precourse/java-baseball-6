package baseball.controller;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    private static final int BASEBALL_GAME_NUMBER_LENGTH = 3;
    private static final char MIN_DIGIT = '1';
    private static final char MAX_DIGIT = '9';
    private static final String WRONG_LENGTH_THROW_MESSAGE = "세 자리 숫자를 입력하세요.";
    private static final String WRONG_RANGE_THROW_MESSAGE = "1-9 사이의 정수를 입력하세요.";
    private static final String DUPLICATE_INPUT_MESSAGE = "중복되지 않는 서로 다른 숫자를 입력해주세요.";
    private static final String CONTINUE_NUMBER = "1";
    private static final String GAME_TERMINATE_NUMBER = "2";
    private static final String WRONG_INPUT_GAME_CONTINUE_CHOICE_MESSAGE = "재시작/종료 여부는 1 또는 2를 입력해주세요.";

    public boolean isThreeLengthLetter(String playerInput) {
        return playerInput.length() == BASEBALL_GAME_NUMBER_LENGTH;
    }

    public boolean isAllDigit(String playerInput) {
        for (int i = 0; i < playerInput.length(); i++) {
            if (playerInput.charAt(i) < MIN_DIGIT || playerInput.charAt(i) > MAX_DIGIT) {
                return false;
            }
        }
        return true;
    }

    public boolean hasDuplicateChars(String playerInput) {
        Set<Character> seenChar = new HashSet<>();
        for (int i = 0; i < playerInput.length(); i++) {
            if (seenChar.contains(playerInput.charAt(i))) {
                return true;
            }
            seenChar.add(playerInput.charAt(i));
        }
        return false;
    }

    public boolean isValidNumber(String playerInput) {
        if (!isThreeLengthLetter(playerInput)) {
            throw new IllegalArgumentException(WRONG_LENGTH_THROW_MESSAGE);
        } else if (!isAllDigit(playerInput)) {
            throw new IllegalArgumentException(WRONG_RANGE_THROW_MESSAGE);
        } else if (hasDuplicateChars(playerInput)) {
            throw new IllegalArgumentException(DUPLICATE_INPUT_MESSAGE);
        }
        return true;
    }

    public boolean isValidContinueGameChoice(String playerInput) {
        if (playerInput == CONTINUE_NUMBER || playerInput == GAME_TERMINATE_NUMBER) {
            return true;
        }
        throw new IllegalArgumentException(WRONG_INPUT_GAME_CONTINUE_CHOICE_MESSAGE);
    }

}
