package baseball;

import javax.print.MultiDocPrintService;
import java.util.HashSet;

public class Game {
    private static final int numLength = 3;

    public static Score calScore(String answer, String userNum) {
        boolean[] alreadyStrike = strike(answer, userNum);
        int strikeCount = 0;

        for (boolean aS : alreadyStrike) {
            if (aS) {
                strikeCount++;
            }
        }

        int ballCount = ball(answer, userNum, alreadyStrike);
        return new Score(strikeCount, ballCount);
    }

    private static boolean[] strike(String answer, String userNum) {
        boolean[] visit = new boolean[numLength];

        for (int i=0; i<numLength; i++) {
            if (answer.charAt(i)-'0' == userNum.charAt(i)-'0') {
                visit[i] = true;
            }
        }

        return visit;
    }

    private static int ball(String answer, String userNum, boolean[] visit) {
        HashSet<Integer> answerSet = new HashSet<>();
        HashSet<Integer> userNumSet = new HashSet<>();

        for (int i=0; i<numLength; i++) {
            if (!visit[i]) {
                answerSet.add(answer.charAt(i)-'0');
                userNumSet.add(userNum.charAt(i)-'0');
            }
        }

        answerSet.retainAll(userNumSet);

        return answerSet.size();
    }
}
