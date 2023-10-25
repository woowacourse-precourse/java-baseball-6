package baseball.dto.output;

import baseball.constants.Message;
import baseball.model.BaseballGameResult;
import baseball.model.BaseballGameResultType;

public class ResultMessageDto {

    private final BaseballGameResult baseballGameResult;

    public ResultMessageDto(BaseballGameResult baseballGameResult) {
        this.baseballGameResult = baseballGameResult;
    }

    public String toMessage() {
        int strikeCount = baseballGameResult.getCount(BaseballGameResultType.STRIKE);
        int ballCount = baseballGameResult.getCount(BaseballGameResultType.BALL);

        return createMessage(strikeCount, ballCount);
    }

    private String createMessage(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            return Message.NOTHING;
        }

        StringBuilder sb = new StringBuilder();
        appendResultMessage(sb, ballCount, Message.BALL);
        appendResultMessage(sb, strikeCount, Message.STRIKE);

        return sb.toString()
                .trim();
    }

    private void appendResultMessage(final StringBuilder sb, final int count, final String message) {
        if (count != 0) {
            sb.append(count)
                    .append(message)
                    .append(" ");
        }
    }
}