package baseball;

public class OutputMessage {

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void demandNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public static void demandContinueFlag() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printResultMessage(int ballCount, int strikeCount) {
        if (strikeCount == 3)
            resultCorrect();
        else if (ballCount == 0 && strikeCount == 0)
            resultNothing();
        else if (ballCount > 0 && strikeCount == 0)
            resultBallCount(ballCount);
        else if (ballCount == 0 && strikeCount > 0)
            resultStrikeCount(strikeCount);
        else if (ballCount > 0 && strikeCount > 0)
            resultBallAndStrikeCount(ballCount, strikeCount);
    }

    public static void resultBallCount(int ballCount) {
        System.out.println(ballCount+"볼");
    }

    public static void resultStrikeCount(int strikeCount) {
        System.out.println(strikeCount+"스트라이크");
    }

    public static void resultBallAndStrikeCount(int ballCount, int strikeCount) {
        System.out.println(ballCount+"볼 "+strikeCount+"스트라이크");
    }

    public static void resultNothing() {
        System.out.println("낫싱");
    }

    public static void resultCorrect() {
        resultStrikeCount(3);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
