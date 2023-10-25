package baseball.view;

import baseball.ExceptionMessage;
import baseball.GameMessage;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static String inputPlayerBaseBallNumbers() {
        System.out.print(GameMessage.INPUT_NUMBER_MESSAGE.getMessage());
        String playerInput = readLine();
        validatePlayerBaseBallNumber(playerInput);
        return playerInput;
    }

    public static String inputGamePlayNumber() {
        String playNumber = readLine();
        validateGamePlayNumber(playNumber);
        return playNumber;
    }

    private static void validatePlayerBaseBallNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ExceptionMessage.ILLEGAL_USER_INPUT_MESSAGE.getMessage());
        }
    }

    private static void validateGamePlayNumber(String playNumber) {
        if (!playNumber.equals(GameMessage.NEW_GAME.getMessage()) && !playNumber.equals(GameMessage.QUIT.getMessage())) {
            System.out.println(ExceptionMessage.ILLEGAL_GAME_INPUT_MESSAGE.getMessage());
        }
    }
}