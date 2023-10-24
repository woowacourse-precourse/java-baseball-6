package matcher;

import static error.ErrorMessage.GAME_ERROR;

import java.util.List;

public class BaseBallGameInputMatcher implements InputMatcher<List<Integer>, List<Integer>> {
    private static final String BALL_MESSAGE = "%s볼";
    private static final String STRIKE_MESSAGE = "%s스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";
    private int baseBallCount;
    private int strikeCount;
    private int ballCount;
    private int nothingCount;

    @Override
    public void match(List<Integer> input, List<Integer> target) {
        resetMatch(input.size());

        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).equals(target.get(i))) {
                increaseStrikeCount();
            } else if (target.contains(input.get(i))) {
                increaseBallCount();
            } else {
                increaseNothingCount();
            }
        }

        getMatchResult(this.ballCount, this.strikeCount, this.nothingCount);
    }

    @Override
    public boolean isAllMatched() {
        if (strikeCount == baseBallCount) {
            return true;
        }
        return false;
    }

    private void resetMatch(int baseBallCount) {
        strikeCount = 0;
        ballCount = 0;
        nothingCount = 0;
        this.baseBallCount = baseBallCount;
    }

    void increaseStrikeCount() {
        strikeCount++;
        validateScore();
    }

    void increaseBallCount() {
        ballCount++;
        validateScore();
    }

    void increaseNothingCount() {
        nothingCount++;
        validateScore();
    }

    private void validateScore() {
        if (this.strikeCount + this.ballCount + this.nothingCount > baseBallCount) {
            throw new IllegalArgumentException(GAME_ERROR.getMessage());
        }
    }

    private void getMatchResult(int ballCount, int strikeCount, int nothingCount) {
        StringBuilder result = new StringBuilder();

        if (ballCount != 0) {
            result.append(String.format(BALL_MESSAGE, ballCount)).append(" ");
        }
        if (strikeCount != 0) {
            result.append(String.format(STRIKE_MESSAGE, strikeCount));
        }
        if (nothingCount == baseBallCount) {
            result.append(NOTHING_MESSAGE);
        }
        System.out.println(result.toString());
    }
}
