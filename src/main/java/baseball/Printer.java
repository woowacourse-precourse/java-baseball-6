package baseball;

public class Printer {

    public static void castStartTheGameMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void castEndTheGameMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void askNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void askRetry() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void castCurrentScore(Score score) {
        int ballCount = score.getBall();
        int strikeCount = score.getStrike();

        if (score.isNothing()) {
            System.out.println("낫싱");
            return;
        }

        if (ballCount != 0) {
            System.out.printf("%d볼 ", ballCount);
        }

        if (strikeCount != 0) {
            System.out.printf("%d스트라이크", strikeCount);
        }

        System.out.println();
    }
}
