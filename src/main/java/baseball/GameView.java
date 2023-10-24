package baseball;

public class GameView {
    public GameView() {
    }

    public static void printGameStartMessage() {
        System.out.print("숫자 야구 게임을 시작합니다.");
    }

    public static void printUserInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printResultMessage(int ballCount, int strikeCount) {
        if (ballCount != 0) {
            System.out.print(ballCount + "볼");
        }

        if (ballCount != 0 && strikeCount != 0) {
            System.out.print(" ");
        }

        if (strikeCount != 0) {
            System.out.print(strikeCount + "스트라이크");

        }
        if (ballCount == 0 && strikeCount == 0) {
            System.out.print("낫싱");
        }

        if (strikeCount == 3) {
            System.out.println();
            System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        }

        System.out.println();
    }

    public static void printRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
