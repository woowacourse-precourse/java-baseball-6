package baseball.view;

import static baseball.util.MessageConstants.BALL_MESSAGE;
import static baseball.util.MessageConstants.NO_STRIKE_NO_BALL_MESSAGE;
import static baseball.util.MessageConstants.STRIKE_MESSAGE;
import static baseball.util.MessageConstants.SUCCESS_MESSAGE;
import static baseball.util.NumberConstants.LIMIT_NUMBERS_SIZE;

import baseball.util.CalculationResult;

public class GameView {

    private User user;

    public GameView(User user) {
        this.user = user;
    }

    public void showStartMessage() {
        user.showStartMessage();
    }

    public String getUserInput() {
        return user.getUserInput();
    }

    public String getGameChoiceInput() {
        return user.getGameChoiceInput();
    }

    public String showGameResult(CalculationResult result) {
        StringBuilder sb = new StringBuilder();
        int strikeCnt = result.getStrikeCnt();
        int ballCnt = result.getBallCnt();
        if (strikeCnt == LIMIT_NUMBERS_SIZE.getValue()) {
            sb.append(strikeCnt).append(STRIKE_MESSAGE.getContent()).append("\n")
                    .append(SUCCESS_MESSAGE.getContent());
        }
        if (strikeCnt > 0 && ballCnt > 0) {
            sb.append(ballCnt).append(BALL_MESSAGE.getContent()).append(" ")
                    .append(strikeCnt).append(STRIKE_MESSAGE.getContent());
        }
        if (strikeCnt == 0 && ballCnt > 0) {
            sb.append(ballCnt).append(BALL_MESSAGE.getContent());
        }
        if (strikeCnt > 0 && strikeCnt < LIMIT_NUMBERS_SIZE.getValue() && ballCnt == 0) {
            sb.append(strikeCnt).append(STRIKE_MESSAGE.getContent());
        }
        if (strikeCnt == 0 && ballCnt == 0) {
            sb.append(NO_STRIKE_NO_BALL_MESSAGE.getContent());
        }
        return sb.toString();
    }
}
