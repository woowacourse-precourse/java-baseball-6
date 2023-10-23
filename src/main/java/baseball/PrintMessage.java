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

    public static void printGameEndMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
            + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

}
