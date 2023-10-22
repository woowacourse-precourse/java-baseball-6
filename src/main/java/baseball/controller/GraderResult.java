package baseball.controller;

import baseball.model.NumberVO;
import baseball.utility.Constant;

public class GraderResult {

    int ballCount;
    int strikeCount;

    public String setGameResult(NumberVO computer, int user) {
        ballCount = 0;
        strikeCount = 3;
        String sortedResult;

        if (ballCount == 0 && strikeCount == 0) {
            sortedResult = String.format("%s\n", Constant.NOTTING);
        } else if (strikeCount == 0) {
            sortedResult = String.format("%s\n", Constant.BALL);
            sortedResult = String.format(sortedResult, ballCount);
        } else if (ballCount == 0) {
            sortedResult = String.format("%s\n", Constant.STRIKE);
            sortedResult = String.format(sortedResult, strikeCount);
        } else {
            sortedResult = String.format("%s %s\n", Constant.BALL, Constant.STRIKE);
            sortedResult = String.format(sortedResult, ballCount, strikeCount);
        }

        return sortedResult;
    }
}
