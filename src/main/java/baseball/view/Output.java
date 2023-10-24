package baseball.view;

public class Output {
    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printBall(int num) {
        System.out.print(num+"볼 ");
    }

    public static void printStrike(int num) {
        System.out.print(num+"스트라이크");
    }

    public static void printNothing() {
        System.out.println("낫싱");
    }

    public static void printWhenGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
