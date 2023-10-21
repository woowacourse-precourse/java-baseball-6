package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Inputview {

    private static final String RESTART_GAME = "게임을 새로 시작할면 1, 종료하려면 2를 입력하세요.";

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

        return inputOption;
    }
}
