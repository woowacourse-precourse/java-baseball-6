package baseball.message;

public class Printer {

    public static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void input() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public static void exitOption() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void correct() {
        System.out.print("""
                3스트라이크
                3개의 숫자를 모두 맞히셨습니다! 게임 종료
                """);
    }

    public static void nothing() {
        System.out.println("낫싱");
    }

    public static void ball(int ballCount) {
        System.out.println(ballCount + "볼");
    }

    public static void strike(int strikeCount) {
        System.out.println(strikeCount + "스트라이크");
    }

    public static void other(int ballCount, int strikeCount) {
        System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
    }
}
