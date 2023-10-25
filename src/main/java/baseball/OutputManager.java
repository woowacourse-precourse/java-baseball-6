package baseball;

public class OutputManager {

    OutputManagerUtils outputManagerUtils = new OutputManagerUtils();

    void printStartMessage() {
        System.out.println(GeneralMessage.START_MESSAGE.getMessage());
    }

    void printRequestInputMessage() {
        System.out.print(GeneralMessage.REQUEST_INPUT_MESSAGE.getMessage());
    }

    void printStrikeOrBallMessage(int ballNum, int strikeNum) {
        if (outputManagerUtils.isNothing(ballNum, strikeNum)) {
            System.out.println(GeneralMessage.NOTHING_MESSAGE.getMessage());
            return ;
        } else if (outputManagerUtils.isTerminated(ballNum, strikeNum)) {
            System.out.println(GeneralMessage.THREE_STRIKE_MESSAGE.getMessage());
            return ;
        } else if (outputManagerUtils.isBall(strikeNum)) {
            System.out.println(ballNum+"볼");
            return ;
        } else if (outputManagerUtils.isStrike(ballNum)) {
            System.out.println(strikeNum+"스트라이크");
            return ;
        }
        System.out.println(ballNum+"볼 "+strikeNum+"스트라이크");
    }

    void printRetryOrEndMessage() {
        System.out.println(GeneralMessage.REQUEST_RETRY_INPUT_MESSAGE.getMessage());
    }
}

class OutputManagerUtils {

    boolean isNothing(int ballNum, int strikeNum) {
        return (ballNum == 0 && strikeNum == 0);
    }

    boolean isStrike(int ballNum) {
        return (ballNum == 0);
    }

    boolean isTerminated(int ballNum, int strikeNum) {
        return (ballNum == 0 && strikeNum == 3);
    }

    boolean isBall(int strikeNum) {
        return (strikeNum == 0);
    }
}