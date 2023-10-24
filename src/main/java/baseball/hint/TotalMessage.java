package baseball.hint;

import baseball.constant.StatusMessage;

public class TotalMessage {
    public static String sumMessage(int ballCount, int strikeCount) {
        return Message.getMessage(ballCount, StatusMessage.BALL) + " " + Message.getMessage(strikeCount,
                StatusMessage.STRIKE);
    }
}
