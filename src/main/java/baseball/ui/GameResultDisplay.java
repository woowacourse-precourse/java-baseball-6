package baseball.ui;

import baseball.result.BaseballGameResult;

/**
 * @author 민경수
 * @description game result display
 * @since 2023.10.23
 **********************************************************************************************************************/
public class GameResultDisplay extends GameStartDisplay implements PrintResultMessage {

    @Override
    public void print(BaseballGameResult baseballGameResult) {
        int ballCount = baseballGameResult.ballCount();
        int strikeCount = baseballGameResult.strikeCount();

        String message = "";

        message += this.ballGenerator(ballCount);
        message += this.strikeGenerator(strikeCount);

        if (ballCount == 0 && strikeCount == 0) {
            message = "낫싱";
        }

        super.print(message);
    }

    private String ballGenerator(int ballCount) {
        if (ballCount == 0) {
            return "";
        }

        return ballCount + "볼 ";
    }

    private String strikeGenerator(int strikeCount) {
        if (strikeCount == 0) {
            return "";
        }

        return strikeCount + "스트라이크 ";
    }

}