package baseball.presentation;

public class Message {
    private static final String startMessage = "숫자 야구 게임을 시작합니다.";
    private static final String restartMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String inputMessage = "숫자를 입력해주세요 : ";
    private static final String nothingCaseMessage = "낫싱";
    private static final String ballCaseMessage = "%d볼";
    private static final String strikeCaseMessage = "%d스트라이크";
    private static final String ballStrikeCaseMessage = "%d볼 %d스트라이크";
    private static final String EndMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printStartMessage() {
        System.out.println(startMessage);
    }

    public void printRestartMessage() {
        System.out.println(restartMessage);
    }

    //printInputMessage
    public void printInputMessage() {
        System.out.print(inputMessage);
    }

    public void nothingCaseMessage() {
        System.out.println(nothingCaseMessage);
    }

    public void printBallCaseMessage(int ballCount) {
        String ballMessage = String.format(ballCaseMessage, ballCount);
        System.out.println(ballMessage);
    }

    public void printStrikeCaseMessage(int strikeCount) {
        String strikeMessage = String.format(strikeCaseMessage, strikeCount);
        System.out.println(strikeMessage);
    }

    public void printballStrikeCaseMessage(int ballCount, int strikeCount) {
        String ballStrikeMessage = String.format(ballStrikeCaseMessage, ballCount, strikeCount);
        System.out.println(ballStrikeMessage);
    }

    public void printEndMessage() {
        System.out.println(EndMessage);
    }
}
