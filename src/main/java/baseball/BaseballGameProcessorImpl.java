package baseball;

import static baseball.BaseballConstants.*;

import java.util.HashSet;
import java.util.Set;


public class BaseballGameProcessorImpl implements BaseballGameProcessor {

    private static final int INIT_NUMBER = 0;

    @Override
    public String process(String o1, String o2) {
        Set<Character> box = new HashSet<>();
        int strikeCount = INIT_NUMBER, ballCount = INIT_NUMBER;
        for (int i= INIT_NUMBER; i<o1.length(); i++) {
            box.add(o1.charAt(i));
        }
        for (int i= INIT_NUMBER; i<o2.length(); i++) {
            if (!box.contains(o2.charAt(i))) continue;
            if (o1.charAt(i)==o2.charAt(i)) {
                strikeCount++;
                continue;
            }
            ballCount++;
        }
        return makeResultString(strikeCount, ballCount);
    }

    private String makeResultString(int strikeCount, int ballCount) {
        StringBuilder sb = new StringBuilder();
        if (ballCount != INIT_NUMBER) {
            sb.append(ballCount + BALL + BLANK);
        }
        if (strikeCount != INIT_NUMBER) {
            sb.append(strikeCount + STRIKE);
        }
        if (sb.isEmpty()) {
            sb.append(NOTHING);
        }
        return sb.toString().trim();
    }
}
