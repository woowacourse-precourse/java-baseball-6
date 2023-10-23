package baseball.vo;

import java.util.List;

public final class GameResult {

    private final List<Integer> result;

    public GameResult(List<Integer> result) {
        this.result = result;
    }

    public GameResult makeNewGameResult(List<Integer> result) {
        return new GameResult(result);
    }

    private Integer getStrikeCount() {
        return result.get(0);
    }

    private Integer getBallCount() {
        return result.get(1);
    }

    public String makeStrikeJudgementMessage() {
        Integer strikeCount = getStrikeCount();
        return strikeCount + "스트라이크";
    }

    public String makeBallJudgementMessage() {
        Integer ballCount = getBallCount();
        return ballCount + "볼";
    }

    public String makeStrikeAndBallJudgement() {
        return makeBallJudgementMessage() + " " + makeStrikeJudgementMessage();
    }

    public String makeNoStrikeAndNoBallJudgementMessage() {
        return "낫싱";
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
