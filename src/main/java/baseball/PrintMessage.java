package baseball;

public class PrintMessage {

    public static void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printReadNumberMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printGameResultMessage(int[] strikeAndBallCount) {

        int strikeCount = strikeAndBallCount[0];
        int ballCount = strikeAndBallCount[1];

        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        } else if (strikeCount == 0 && ballCount > 0) {
            System.out.println(ballCount + "볼");
        } else if (strikeCount > 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (strikeCount > 0 && ballCount > 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }

}
