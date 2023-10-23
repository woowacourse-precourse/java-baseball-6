package baseball.domain;

public class ComparisonResult {

    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";

    private final String ResultMessage;
    private int strikeCount;
    private int ballCount;

    public ComparisonResult(PlayerNumber player, ComputerNumber computer) {
        compare(player, computer);
        ResultMessage = makeCompareMessage();
    }


    private void compare(PlayerNumber player, ComputerNumber computer) {
        for (int i = 0; i < 3; i++) {
            int number = player.getIndexNumber(i);
            if (computer.isNumberContains(number)) {
                if (computer.getNumberIndex(number) == i) {
                    strikeCount++;
                } else {
                    ballCount++;
                }
            }
        }
    }

    private String makeCompareMessage() {
        if (ballCount == 0 && strikeCount == 0) {
            return NOTHING_MESSAGE;
        }

        String makeMessage = "";
        if (0 < ballCount) {
            makeMessage += (ballCount + BALL_MESSAGE + " ");
        }
        if (0 < strikeCount) {
            makeMessage += (strikeCount + STRIKE_MESSAGE);
        }

        return makeMessage;
    }

    public boolean isGameEnd() {
        return strikeCount == 3;
    }

    public String getResultMessage() {
        return ResultMessage;
    }
}