package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Inputview {

    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String PLEASE_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String RESTART_GAME = "게임을 새로 시작할면 1, 종료하려면 2를 입력하세요.";

    public static void startGame() {
        System.out.println(START_GAME);
    }

    public static String inputNumber() {
        System.out.print(PLEASE_INPUT_NUMBER);
        String inputNumber = Console.readLine();

        Validation.checkLengthThree(inputNumber);
        Validation.checkStringRegex(inputNumber);

        return inputNumber;
    }

    public static String reStart() {
        System.out.println(RESTART_GAME);
        String inputOption = Console.readLine();

        return inputOption;
    }
}
