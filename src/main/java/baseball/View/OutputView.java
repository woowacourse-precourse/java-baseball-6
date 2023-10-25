package baseball.View;

public class OutputView {

    private String startMessage = "숫자 야구 게임을 시작합니다.";
    private String nothing = "낫싱";
    private String ballResult = "%d볼";
    private String strikeResult = "%d스트라이크";
    private String ballAndStrikeResult = "%d볼 %d스트라이크";
    private String successMessage = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료.";
    private String endMessage = "숫자 야구 게임을 종료합니다.";


    public void printStartMessage() {
        System.out.println(startMessage);
    }

    public void resultMessage(int ballNum, int strikeNum) {
        if(ballNum == 0 && strikeNum == 0) {
            System.out.println(nothing);
        }
        else if(ballNum == 0 && strikeNum != 0) {
            System.out.printf(strikeResult, strikeNum);
            System.out.println();
        }
        else if(ballNum != 0 && strikeNum == 0) {
            System.out.printf(ballResult, ballNum);
            System.out.println();
        }
        else {
            System.out.printf(ballAndStrikeResult, ballNum, strikeNum);
            System.out.println();
        }
    }

    public void successMessage(int length) {
        System.out.printf(successMessage, length);
        System.out.println();
    }

    public void printEndMessage() {
        System.out.println(endMessage);
    }
}
