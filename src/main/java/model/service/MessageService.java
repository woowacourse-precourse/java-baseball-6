package model.service;

import java.util.List;

public class MessageService {
    private static final String STRIKETEXT = "스트라이크";
    private static final String BALLTEXT = "볼";
    private static final String NOTHINGTEXT = "낫싱";

    public String resultMessage(int ball, int strike) {
        StringBuffer sb = new StringBuffer();

        if (strike == 0 && ball == 0) {
            sb.append(NOTHINGTEXT);
        }
        if (ball > 0) {
            sb.append(ball + BALLTEXT + " ");
        }
        if (strike > 0) {
            sb.append(strike + STRIKETEXT);
        }

        return sb.toString();
    }
}
