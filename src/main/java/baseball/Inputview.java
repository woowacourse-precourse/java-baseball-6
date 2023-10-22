package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Inputview {

    public static void startGame() {
        System.out.println(OutputMessage.START_GAME);
    }

    public static String inputNumber() {
        System.out.print(OutputMessage.PLEASE_INPUT_NUMBER);
        String inputNumber = Console.readLine();

        Validation.checkLengthThree(inputNumber);
        Validation.checkStringRegex(inputNumber);

        return inputNumber;
    }

    public static String reStart() {
        System.out.println(OutputMessage.RESTART_GAME);
        String inputOption = Console.readLine();

        Validation.checkLengthOne(inputOption);
        Validation.checkStringRegex(inputOption);

        return inputOption;
    }
}
