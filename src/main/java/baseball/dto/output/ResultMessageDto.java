package baseball.dto.output;

import baseball.constants.Message;
import baseball.model.BaseballGameResult;
import baseball.model.BaseballGameResultType;

public record ResultMessageDto(BaseballGameResult baseballGameResult) {

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
        addResultMessage(sb, ballCount, Message.BALL);
        addResultMessage(sb, strikeCount, Message.STRIKE);

        return sb.toString()
                .trim();
    }

    private void addResultMessage(final StringBuilder sb, final int count, final String message) {
        if (count != 0) {
            sb.append(count)
                    .append(message)
                    .append(" ");
        }
    }
}
