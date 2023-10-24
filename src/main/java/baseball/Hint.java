package baseball;

import java.util.List;

public class Hint {
    public static String generateHint(int userNumber, List<Integer> computerNumber) {

        int sameNumber = SameValue.sameNumberCount(userNumber, computerNumber);
        int sameCount = SameValue.sameIndexCount(userNumber, computerNumber);

        if (sameNumber == 0) {
            return "낫싱";
        }

        StringBuilder result = new StringBuilder();
        appendBallCount(sameNumber, sameCount, result);
        appendStrikeCount(sameCount, result);

        return result.toString();
    }

    private static void appendBallCount(int sameNumber, int sameCount, StringBuilder result) {
        if (sameNumber - sameCount > 0) {
            result.append(sameNumber - sameCount).append("볼");
        }
    }

    private static void appendStrikeCount(int sameCount, StringBuilder result) {
        if (sameCount > 0 && !result.isEmpty()) {
            result.append(" ");
        }
        if (sameCount > 0) {
            result.append(sameCount).append("스트라이크");
        }
    }
}
