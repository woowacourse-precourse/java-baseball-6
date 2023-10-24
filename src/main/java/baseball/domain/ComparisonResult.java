package baseball.domain;

import static baseball.constant.ResultMessage.*;

public class ComparisonResult {

    private final String message;
    private int strikeCount;
    private int ballCount;

    public ComparisonResult(PlayerNumber player, ComputerNumber computer) {
        compare(player, computer);
        message = makeCompareMessage();
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

        if (0 < ballCount && 0 < strikeCount) {
            return String.format(BALL_STRIKE_MESSAGE, ballCount, strikeCount);
        }
        if (0 < ballCount) {
            return String.format(BALL_ONLY_MESSAGE, ballCount);
        }
        return String.format(STRIKE_ONLY_MESSAGE, strikeCount);
    }


    public boolean isGameEnd() {
        return strikeCount == 3;
    }

    public String getMessage() {
        return message;
    }
}