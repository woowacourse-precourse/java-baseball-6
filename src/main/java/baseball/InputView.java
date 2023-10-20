package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final int ONE_OR_TWO_LEN = 1;
    private static final int CONTINUE = 1;
    private static final int END = 2;

    public static String askNumber(int listLen) {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        validateInputLength(input, listLen);

        return input;
    }

    public static boolean askOneOrTwo() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        validateInputLength(input, ONE_OR_TWO_LEN);

        int inputNum = input.charAt(0) - '0';
        validateOneOrTwo(inputNum);

        return inputNum == CONTINUE;
    }

    private static void validateOneOrTwo(int inputNum) {
        if (inputNum != CONTINUE && inputNum != END) {
            throw new IllegalArgumentException("1 또는 2 만 입력해야 합니다.");
        }
    }

    public static void validateInputLength(String input, int value) {
        if (input.length() != value) {
            throw new IllegalArgumentException(value + " 자리를 입력해야 합니다.");
        }
    }
}
