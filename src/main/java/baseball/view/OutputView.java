package baseball.view;

public class OutputView {
    public static void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputNumberMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printResultMessage(int ballCount, int strikeCount) {

        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
            return;
        }

        StringBuilder builder = new StringBuilder();
        if (ballCount != 0) {
            builder.append(ballCount).append("볼 ");
        }
        if (strikeCount != 0) {
            builder.append(strikeCount).append("스트라이크");
        }
        System.out.println(builder);
    }

    public static void printGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
