package baseball.domain;

import java.util.List;

public class Result {

    private static final String STRIKE_MESSAGE = "%d스트라이크";
    private static final String BALL_MESSAGE = "%d볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String SPACE = " ";
    private static final int END_STRIKE_LENGTH = 3;
    private int strikeCount;
    private int ballCount;

    public Result(Computer computer, User user) {
        List<Integer> computerList = computer.getComputerList();
        for (int number : user.getUserList()) {
            if (computerList.contains(number)) {
                this.ballCount++;
            }
            if (computerList.indexOf(number) == user.getUserList().indexOf(number)) {
                this.ballCount--;
                this.strikeCount++;
            }
        }
    }

    public String resultToString() {
        if (ballCount == 0 && strikeCount == 0) {
            return NOTHING_MESSAGE;
        } else if (ballCount == 0) {
            return String.format(STRIKE_MESSAGE, strikeCount);
        } else if (strikeCount == 0) {
            return String.format(BALL_MESSAGE, ballCount);
        }
        return String.format(BALL_MESSAGE + SPACE + STRIKE_MESSAGE, ballCount, strikeCount);
    }

    public boolean isContinue() {
        return this.strikeCount != END_STRIKE_LENGTH;
    }

}
