package baseball;

public class Message {
    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void input() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printResult(int ballCount, int strikeCount) {
        if (ballCount != 0 && strikeCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        } else if (ballCount != 0) {
            System.out.println(ballCount + "볼");
        } else if (strikeCount != 0) {
            System.out.println(strikeCount + "스트라이크");
        } else {
            System.out.println("낫싱");
        }
    }

    public static void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void endOrRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
