package baseball.vo;

import java.util.List;

public final class GameResult {

    private final List<Integer> result;

    private final Message message;

    public GameResult(List<Integer> result, Message message) {
        this.result = result;
        this.message = message;
    }

    public GameResult makeNewGameResult(List<Integer> result) {
        Message message = new Message(null);
        return new GameResult(result, message);
    }

    private Integer getStrikeCount() {
        return result.get(0);
    }

    private Integer getBallCount() {
        return result.get(1);
    }

    public Message makeStrikeJudgementMessage() {
        Integer strikeCount = getStrikeCount();
        String strikeMessage = strikeCount + "스트라이크";
        return message.makeNewGameResultMessage(strikeMessage);
    }

    public Message makeBallJudgementMessage() {
        Integer ballCount = getBallCount();
        String ballMessage = ballCount + "볼";
        return message.makeNewGameResultMessage(ballMessage);
    }

    public Message makeStrikeAndBallJudgementMessage() {
        Integer strikeCount = getStrikeCount();
        Integer ballCount = getBallCount();
        String strikeMessage = strikeCount + "스트라이크";
        String ballMessage = ballCount + "볼";
        String ballAndStrikeMessage = ballMessage + " " + strikeMessage;
        return message.makeNewGameResultMessage(ballAndStrikeMessage);
    }

    public Message makeNoStrikeAndNoBallJudgementMessage() {
        String noBallAndNoStrikeMessage = "낫싱";
        return message.makeNewGameResultMessage(noBallAndNoStrikeMessage);
    }

    private boolean isStrikeCountEqualZero() {
        Integer strikeCount = getStrikeCount();
        return strikeCount.equals(0);
    }

    private boolean isBallCountEqualZero() {
        Integer ballCount = getBallCount();
        return ballCount.equals(0);
    }

    private boolean isStrikeCountNotEqualZero() {
        Integer strikeCount = getStrikeCount();
        return !strikeCount.equals(0);
    }

    private boolean isBallCountNotEqualZero() {
        Integer ballCount = getBallCount();
        return !ballCount.equals(0);
    }

    public boolean isStrikeCountNotEqualZeroAndBallCountEqualZero() {
        return isStrikeCountNotEqualZero() && isBallCountEqualZero();
    }

    public boolean isStrikeCountNotEqualZeroAndBallCountNotEqualZero() {
        return isStrikeCountNotEqualZero() && isBallCountNotEqualZero();
    }

    public boolean isStrikeCountEqualZeroAndBallCountNotEqualZero() {
        return isStrikeCountEqualZero() && isBallCountNotEqualZero();
    }
}
