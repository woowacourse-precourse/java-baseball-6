package baseball;

public class OutputManager {

    void printStartMessage() {
        System.out.println(GeneralMessage.START_MESSAGE.getMessage());
    }

    void printRequestInputMessage() {
        System.out.print(GeneralMessage.REQUEST_INPUT_MESSAGE.getMessage());
    }

    void printStrikeOrBallMessage(int ballNum, int strikeNum) {
        if (ballNum == 0 && strikeNum == 0) {
            System.out.println(GeneralMessage.NOTHING_MESSAGE.getMessage());
            return ;
        } else if (ballNum == 0 && strikeNum == 3) {
            System.out.println(GeneralMessage.THREE_STRIKE_MESSAGE.getMessage());
            return ;
        } else if (strikeNum == 0) {
            System.out.println(ballNum+"볼");
            return ;
        } else if (ballNum == 0) {
            System.out.println(strikeNum+"스트라이크");
            return ;
        }
        System.out.println(ballNum+"볼 "+strikeNum+"스트라이크");
    }

    void printRetryOrEndMessage() {
        System.out.println(GeneralMessage.REQUEST_RETRY_INPUT_MESSAGE.getMessage());
    }
}