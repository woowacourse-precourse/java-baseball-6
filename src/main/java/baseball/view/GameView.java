package baseball.view;

import static baseball.model.message.ErrorMessage.DO_NOT_CALL_THIS_CODE;
import static baseball.model.message.ErrorMessage.INVALID_INPUT;
import static baseball.model.message.ErrorMessage.INVALID_NUMBER;
import static baseball.model.message.ErrorMessage.POSITIVE_NUMBER_NEED;
import static baseball.model.message.UserMessage.ASK_REPLAY_MESSAGE;
import static baseball.model.message.UserMessage.DONE_MESSAGE;
import static baseball.model.message.UserMessage.INPUT_GUIDE_MESSAGE;
import static baseball.model.message.UserMessage.START_MASSAGE;

import baseball.model.Result;
import camp.nextstep.edu.missionutils.Console;

public class GameView {

    private GameView() {
        throw new AssertionError(DO_NOT_CALL_THIS_CODE.getMessage());
    }

    public static String inputPositiveNumber() {
        String inputString = Console.readLine();
        validateInput(inputString);
        return inputString;
    }

    private static void validateInput(String inputString) {
        validateBlankString(inputString);
        validateNumber(inputString);
        validatePositiveNumber(inputString);
    }

    private static void validateBlankString(String string) {
        if (string.isBlank()) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    private static void validateNumber(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER.getMessage());
        }
    }

    private static void validatePositiveNumber(String string) {
        if (Integer.parseInt(string) <= 0) {
            throw new IllegalArgumentException(POSITIVE_NUMBER_NEED.getMessage());
        }
    }

    public static void printStartMessage() {
        System.out.println(START_MASSAGE);
    }

    public static void printInputGuideMessage() {
        System.out.print(INPUT_GUIDE_MESSAGE);
    }

    public static void printResult(Result result) {
        System.out.println(result);
    }

    public static void printDoneMessage() {
        System.out.println(DONE_MESSAGE);
    }

    public static void printReplayMessage() {
        System.out.println(ASK_REPLAY_MESSAGE);
    }
}
