package baseball;

public class Printer {

    static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    static void input() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    static void exitOption() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    static void correct() {
        System.out.print("""
                3스트라이크
                3개의 숫자를 모두 맞히셨습니다! 게임 종료
                """);
    }

    static void nothing() {
        System.out.println("낫싱");
    }

    static void ball(int ballCount) {
        System.out.println(ballCount + "볼");
    }

    static void strike(int strikeCount) {
        System.out.println(strikeCount + "스트라이크");
    }

    static void other(int ballCount, int strikeCount) {
        System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
    }
}
