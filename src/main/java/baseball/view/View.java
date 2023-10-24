package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class View {
    private static final String END_COMMAND = "1";
    private static final String RESTART_COMMAND = "2";
    private static final int INPUT_NUMBER_SIZE = 3;

    public static String readUserNumber() {
        printInputNumberMessage();
        String inputNumber = Console.readLine();
        checkInputNumber(inputNumber);

        return inputNumber;
    }

    private static void checkInputNumber(String inputNumber) {
        checkIsNumber(inputNumber);
        checkNumberSize(inputNumber);
        checkNumberRange(inputNumber);
        checkDuplicatedNumber(inputNumber);
    }

    private static void checkIsNumber(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }
    }

    private static void checkNumberSize(String inputNumber) {
        if (inputNumber.length() != INPUT_NUMBER_SIZE) {
            throw new IllegalArgumentException("반드시 3개의 숫자여야 합니다.");
        }
    }

    private static void checkNumberRange(String inputNumber) {
        if (inputNumber.contains("0")) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만 입력이 가능합니다.");
        }
    }

    private static void checkDuplicatedNumber(String inputNumber) {
        String[] numbers = inputNumber.split("");
        long count = Arrays.stream(numbers).distinct().count();

        if (count != INPUT_NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }

    public static int readGameEndCommand() {
        printGameEndMessage();
        String inputCommand = Console.readLine();

        checkEndCommandType(inputCommand);

        return Integer.parseInt(inputCommand);
    }

    private static void checkEndCommandType(String inputCommand) {
        if (!inputCommand.equals(END_COMMAND) && !inputCommand.equals(RESTART_COMMAND)) {
            throw new IllegalArgumentException("잘못된 종료 커멘드입니다.");
        }
    }

    public static void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputNumberMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printResultMessage(int ballCount, int strikeCount) {

        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
            return;
        }

        StringBuilder builder = new StringBuilder();
        if (ballCount != 0) {
            builder.append(ballCount).append("볼 ");
        }
        if (strikeCount != 0) {
            builder.append(strikeCount).append("스트라이크");
        }
        System.out.println(builder);
    }

    public static void printGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
