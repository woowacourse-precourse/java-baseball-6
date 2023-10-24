package baseball;

import static baseball.Constants.*;

import java.util.HashSet;
import java.util.Set;

public class GameRule {
    public static int countBallAndStrike(String computeNumber, String userNumber) {

        char[] computeNumberArray = computeNumber.toCharArray();
        char[] userNumberArray = userNumber.toCharArray();

        Set<Character> computeNumberHS = new HashSet<>();
        Set<Character> userNumberHS = new HashSet<>();

        for (char c : computeNumberArray) {
            computeNumberHS.add(c);
        }
        for (char u : userNumberArray) {
            userNumberHS.add(u);
        }

        // 교집합 생성
        computeNumberHS.retainAll(userNumberHS);
        return computeNumberHS.size();
    }

    public static int countStrike(String computeNumber, String userNumber) {
        int cntS = 0;
        for (int i=0; i < validLength; i++) {
            if (computeNumber.charAt(i) == userNumber.charAt(i)) {
                cntS++;
            }
        }
        return cntS;
    }

    public static String hintProvider(int cntB, int cntS) {
        if (cntS == 3) {
            return HintMessage.ALLSTRIKE.get();
        }
        if (cntB == 0 && cntS == 0) {
            return HintMessage.NOTHINGMESSAGE.get();
        }
        if (cntB == 0) {
            return HintMessage.STRIKEFORMAT.get().formatted(cntS);
        }
        if (cntS == 0) {
            return HintMessage.BALLFORMAT.get().formatted(cntB);
        }
        return HintMessage.BALLSTRIKFORMAT.get().formatted(cntB, cntS);
    }
}
