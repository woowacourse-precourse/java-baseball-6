package baseball.application;

public class PrintStateApplication {
    public static void printInputState() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printEndState() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printStartState() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

}
