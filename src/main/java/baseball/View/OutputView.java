package baseball.View;

public class OutputView {
    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printEndMessage() {
        System.out.println("게임을 종료합니다.");
    }

    public static void printAllCorrectStrike() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printBallCount(int ballCount) {
        System.out.println(ballCount + "볼");
    }

    public static void printStrikeCount(int strikeCount) {
        System.out.println(strikeCount + "스트라이크");
    }

    public static void printBallStrikeCount(int ballCount, int strikeCount){
        System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
    }

    public static void printNothing(){
        System.out.println("낫싱");
    }

}
