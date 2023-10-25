package baseball.service;

import baseball.domain.Constants;

public class Hint {

    public static String makeHint(int ballCount, int strikeCount) {
        StringBuilder hint = new StringBuilder(Constants.EMPTY_STRING);

        if (ballCount == 0 && strikeCount == 0) {
            return Constants.NOT_THING;
        }
        if (ballCount > 0) {
            hint.append(ballCount).append(Constants.BALL).append(Constants.SPACE);
        }
        if (strikeCount > 0) {
            hint.append(strikeCount).append(Constants.STRIKE);
        }

        return hint.toString().trim();
    }

}
