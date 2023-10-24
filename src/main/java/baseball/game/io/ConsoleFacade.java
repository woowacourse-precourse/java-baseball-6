package baseball.game.io;

import static baseball.game.message.ErrorMessage.BLANK_INPUT;
import static baseball.game.message.ErrorMessage.INVALID_LENGTH;
import static baseball.game.message.ErrorMessage.NOT_DIGIT;
import static baseball.game.message.GameMessage.GAME_END;
import static baseball.game.message.GameMessage.GAME_MENU;
import static baseball.game.message.GameMessage.GAME_START;
import static baseball.game.message.GameMessage.INPUT_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class ConsoleFacade {

    private static final int MENU_LENGTH = 1;
    private static final int NUMBERS_LENGTH = 3;

    public void printGameStart() {
        System.out.println(GAME_START.getMessage());
    }

    public void printEndGame() {
        System.out.println(GAME_END.getMessage());
    }

    public List<Integer> getNumbers() {
        System.out.print(INPUT_NUMBERS.getMessage());
        String inputNumber = Console.readLine();
        validateNumbers(inputNumber);
        return Arrays.stream(inputNumber.split(""))
                .map(Integer::parseInt)
                .toList();
    }

    public String getMenu() {
        System.out.println(GAME_MENU.getMessage());
        String menuInput = Console.readLine();
        validate(menuInput);
        return menuInput;
    }

    public void printGameScore(final String gameScore) {
        System.out.println(gameScore);
    }

    private void validateNumbers(final String inputNumber) {
        validateIsBlank(inputNumber);
        validateIsDigit(inputNumber);
        validateLength(inputNumber, NUMBERS_LENGTH);
    }

    private void validate(final String menuInput) {
        validateIsBlank(menuInput);
        validateIsDigit(menuInput);
        validateLength(menuInput, MENU_LENGTH);
    }

    private void validateIsBlank(final String menuInput) {
        if (menuInput.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT.getMessage());
        }
    }

    private void validateIsDigit(final String menuInput) {
        boolean isAllDigit = menuInput.chars()
                .allMatch(Character::isDigit);
        if (!isAllDigit) {
            throw new IllegalArgumentException(NOT_DIGIT.getMessage());
        }
    }

    private void validateLength(final String inputNumber, final int targetLength) {
        if (inputNumber.length() != targetLength) {
            throw new IllegalArgumentException(INVALID_LENGTH.getMessage());
        }
    }


}
