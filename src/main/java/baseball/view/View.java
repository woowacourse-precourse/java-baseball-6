package baseball.view;

import baseball.domain.Computer;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class View {

    public static String readPlayerNumber() {
        printInputNumberMessage();
        String playerNumber = Console.readLine();
        checkInputNumber(playerNumber);

        return playerNumber;
    }

    private static void checkInputNumber(String playerNumber) {
        checkIsNumber(playerNumber);
        checkNumberSize(playerNumber);
        checkNumberRange(playerNumber);
        checkDuplicatedNumber(playerNumber);
    }

    private static void checkIsNumber(String playerNumber) {
        try {
            Integer.parseInt(playerNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }
    }

    private static void checkNumberSize(String playerNumber) {
        if (playerNumber.length() != Computer.NUMBER_SIZE) {
            throw new IllegalArgumentException("반드시 3개의 숫자여야 합니다.");
        }
    }

    private static void checkNumberRange(String playerNumber) {
        if (playerNumber.contains("0")) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만 입력이 가능합니다.");
        }
    }

    private static void checkDuplicatedNumber(String playerNumber) {
        String[] numbers = playerNumber.split("");
        long count = Arrays.stream(numbers).distinct().count();

        if (count != Computer.NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }

    public static String readGameEndCommand() {
        printGameEndMessage();
        String command = Console.readLine();

        checkEndCommandType(command);

        return command;
    }

    private static void checkEndCommandType(String command) {
        if (!command.equals(Computer.FINISH_COMMAND) && !command.equals(Computer.RESTART_COMMAND)) {
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
