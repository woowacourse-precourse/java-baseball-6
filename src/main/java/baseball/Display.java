package baseball;


import camp.nextstep.edu.missionutils.Console;

public class Display {
    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static String readLine() {
        return Console.readLine();
    }

    public static String requestUserBall() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }
}
