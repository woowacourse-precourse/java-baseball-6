package baseball.view;

import baseball.domain.Computer;
import baseball.domain.GameResult;
import camp.nextstep.edu.missionutils.Console;

public class View {

    public static String readPlayerNumber() {
        printInputNumberMessage();
        String playerNumber = Console.readLine();
        Computer.validatePlayerNumber(playerNumber);

        return playerNumber;
    }

    public static String readGameEndCommand() {
        printGameEndMessage();
        String command = Console.readLine();
        Computer.validateEndCommandType(command);

        return command;
    }

    public static void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputNumberMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printResultMessage(GameResult gameResult) {
        System.out.println(gameResult);
    }

    public static void printGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
