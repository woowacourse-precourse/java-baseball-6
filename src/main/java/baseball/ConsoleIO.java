package baseball;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleIO {
    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static String readPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");

        return Console.readLine();
    }

    public static void printResultMessage(String resultMessage) {
        System.out.println(resultMessage);
    }

    public static void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
