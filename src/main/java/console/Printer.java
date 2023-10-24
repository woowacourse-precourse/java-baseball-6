package console;

import baseball.Result;

public class Printer {
    public static void printQuit(int perfectNumber) {
        System.out.println(perfectNumber+"개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printExitOrRestart(int restart, int exit) {
        System.out.println("게임을 새로 시작하려면 "+restart+", 종료하려면 "+exit+"를 입력하세요");
    }

    public static void printResult(Result result) {
        System.out.println(result.toString());
    }
}
