package baseball.view;

public class OutputView {

    public static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printCount(int strikeCount, int ballCount) {
        StringBuilder sb = new StringBuilder();
        if (ballCount != 0) {
            sb.append(ballCount).append("볼 ");
        }
        if (strikeCount != 0) {
            sb.append(strikeCount).append("스트라이크");
        }
        if (strikeCount == 0 && ballCount == 0) {
            sb.append("낫싱");
        }
        System.out.println(sb);
    }

    public static void gameOver() {
        System.out.println("게임 종료");
    }
}
