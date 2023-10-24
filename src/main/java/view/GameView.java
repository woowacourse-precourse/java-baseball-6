package view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static String printInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static void printStrike() {
        System.out.print("스트라이크");
    }

    public static void printBall() {
        System.out.print("볼 ");
    }

    public static void printNothingNumber() {
        System.out.println("낫싱");
    }

    public static void printCorrectNumber() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static int printSetGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(Console.readLine());
    }
    
}
