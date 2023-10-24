package baseball;

public class OutputView {
    public static void promptMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void gameOverMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printMatchResult(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.print("낫싱");
        }
        if (ballCount > 0) {
            System.out.printf("%d볼 ", ballCount);
        }
        if (strikeCount > 0) {
            System.out.printf("%d스트라이크", strikeCount);
        }
        System.out.print("\n");
    }

    public static void restartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}

