package baseball.view;


public class OutputView {
    public static String NOTHING = "낫싱";
    public static String BALL = "볼";
    public static String STRIKE = "스트라이크";
    public static void printGameIntroduction() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printScores(int total, int ballCount, int strikeCount) {
        if (total == 0){
            System.out.println(NOTHING);
            return;
        } else if(strikeCount == 0){
            System.out.println(ballCount + BALL);
            return;
        } else if (ballCount == 0) {
            System.out.println(strikeCount + STRIKE);
            return;
        }
        System.out.println(ballCount + BALL + " " + strikeCount + STRIKE);
    }
}
