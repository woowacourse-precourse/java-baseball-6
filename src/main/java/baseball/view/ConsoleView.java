package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleView {
    private static final String GAME_START_OUTPUT_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String THREE_DIGIT_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public static void printGameStart() {
        System.out.println(GAME_START_OUTPUT_MESSAGE);
    }

    public static String inputThreeDigitNumber() {
        System.out.print(THREE_DIGIT_NUMBER_INPUT_MESSAGE);
        return Console.readLine();
    }
}
