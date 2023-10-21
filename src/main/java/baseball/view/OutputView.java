package baseball.view;

public class OutputView {

    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printRequestNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printRequestRestartOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printNothing() {
        System.out.print("낫싱");
    }

    public static void printBallCount(int ballCount) {
        System.out.print(ballCount + "볼");
    }

    public static void printStrikeCount(int strikeCount) {
        System.out.print(strikeCount + "스트라이크");
    }
    
    public static void printBallAndStrikeCount(int ballCount, int strikeCount) {
        System.out.print(ballCount + "볼 " + strikeCount + "스트라이크");
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
