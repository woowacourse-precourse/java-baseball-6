package baseball.view;


import static baseball.util.ConsoleMessages.GAME_OVER;
import static baseball.util.ConsoleMessages.GAME_START;
import static baseball.util.ConsoleMessages.INPUT_NUMBER;
import static baseball.util.ConsoleMessages.RESTART_OR_TERMINATE;
import static baseball.util.GameResultMessageGenerator.makeResultString;
import static baseball.view.ConsoleValidator.validateInput3DigitNumber;
import static baseball.view.ConsoleValidator.validateInputIsNumber;
import static baseball.view.ConsoleValidator.validateInputNotBlank;
import static baseball.view.ConsoleValidator.validateInputNotDuplicate;
import static baseball.view.ConsoleValidator.validateInputNotNull;
import static baseball.view.ConsoleValidator.validateRestartOrTerminate;

import baseball.game.BaseBallGameResult;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Console {

    private static final IllegalArgumentException ILLEGAL_ARGUMENT_EXCEPTION = new IllegalArgumentException();

    public static List<Integer> input3DigitRandomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private static String readLine() {
        try {
            String inputString = camp.nextstep.edu.missionutils.Console.readLine();

            validateInputNotNull(inputString);
            validateInputNotBlank(inputString);
            validateInputIsNumber(inputString);

            return inputString;
        } catch (NoSuchElementException e) {
            throw ILLEGAL_ARGUMENT_EXCEPTION;
        }

    }

    public static List<Integer> input3DigitNumber() {
        String inputString = readLine();

        validateInput3DigitNumber(inputString);
        validateInputNotDuplicate(inputString);

        return Arrays.stream(inputString.split(""))
                .map(Integer::parseInt)
                .toList();
    }

    public static String inputRestartOrTerminate() {

        String inputString = readLine();

        validateRestartOrTerminate(inputString);

        return inputString;
    }


    public static void printGameStart() {
        System.out.println(GAME_START);
    }

    public static void printUserInputMessage() {
        System.out.print(INPUT_NUMBER);
    }

    public static void printUserInputNumber(String userNumber) {
        System.out.println(userNumber);
    }

    public static void printGameResult(BaseBallGameResult result) {
        int strike = result.getStrike();
        int ball = result.getBall();

        String resultMessage = makeResultString(strike, ball);
        System.out.println(resultMessage);
    }

    public static void printGameOver() {
        System.out.println(GAME_OVER);
    }

    public static void printRestartOrTerminate() {
        System.out.println(RESTART_OR_TERMINATE);
    }
}
