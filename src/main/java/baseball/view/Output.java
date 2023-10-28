package baseball.view;

public class Output {
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";

    public void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printBall() {
        System.out.println(BALL);
    }

    public void printStrike() {
        System.out.println(STRIKE);
    }

    public void printBallAndStrike() {
        System.out.print(BALL + " ");
    }

    public void printCount(int count) {
        System.out.print(count);
    }

    public void printNothing() {
        System.out.println(NOTHING);
    }

    public void printEndGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
