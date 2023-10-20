package baseball.view;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static baseball.game.BaseBallGameMessage.*;

public class Console {

    private static final IllegalArgumentException ILLEGAL_ARGUMENT_EXCEPTION = new IllegalArgumentException();
    private static final String NUMBER_REGEX = "[1-9]+";
    private static final List<String> RESTART_OR_TERMINATE = List.of("1", "2");

    public static String input3DigitRandomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return Arrays.toString(computer.toArray());
    }

    private static String readLine() {
        String inputString = camp.nextstep.edu.missionutils.Console.readLine();

        validateInputNotNull(inputString);
        validateInputIsNumber(inputString);

        return inputString;
    }

    public static String input3DigitNumber() {
        String inputString = readLine();

        validateInput3DigitNumber(inputString);
        validateInputNotDuplicate(inputString);

        return inputString;
    }

    public static String inputRestartOrTerminate() {

        String inputString = readLine();

        validateRestartOrTerminate(inputString);

        return inputString;
    }

    private static void validateInputNotNull(String inputString) {
        if (inputString == null) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateInputIsNumber(String inputString) {

        if (!inputString.matches(NUMBER_REGEX)) {
            throw ILLEGAL_ARGUMENT_EXCEPTION;
        }
    }

    private static void validateInput3DigitNumber(String inputString) {

        if (inputString.length() != 3) {
            throw ILLEGAL_ARGUMENT_EXCEPTION;
        }
    }

    private static void validateInputNotDuplicate(String inputString) {
        int[] appearance = new int[10];

        for (char inputChar : inputString.toCharArray()) {
            appearance[inputChar-'0'] ++;
        }

        for (int appeared : appearance) {
            if (appeared>=2) {
                throw ILLEGAL_ARGUMENT_EXCEPTION;
            }
        }

    }

    private static void validateRestartOrTerminate(String inputString) {
        if (!RESTART_OR_TERMINATE.contains(inputString)) {
            throw ILLEGAL_ARGUMENT_EXCEPTION;
        }
    }


    public static void printGameStart(){
        System.out.println(GAME_START);
    }

    public static void printUserInputMessage(){
        System.out.println(INPUT_NUMBER);
    }
}
