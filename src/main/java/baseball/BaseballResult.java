package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseballResult {
    private final List<Integer> strikeZone;
    private static boolean bCorrect;

    BaseballResult() {
        this.strikeZone = makeStrikeZone();
        bCorrect = false;
    }

    public static boolean bCorrect() {
        return bCorrect;
    }

    private static List<Integer> makeStrikeZone() {
        List<Integer> strikeZone = new ArrayList<>();

        while (strikeZone.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!strikeZone.contains(randomNumber)) {
                strikeZone.add(randomNumber);
            }
        }
        return strikeZone;
    }

    public void pitch(List<Integer> maybe) {
        HashMap<String, Integer> result = new HashMap<>();
        result.put("Strike!", 0);
        result.put("Ball..", 0);

        for (int maybeIdx = 0; maybeIdx < 3; maybeIdx++) {
            int containIndex = strikeZone.indexOf(maybe.get(maybeIdx));
            if (containIndex != -1) {
                if (containIndex == maybeIdx) {
                    result.put("Strike!", result.get("Strike!") + 1);
                }
                if (containIndex == maybeIdx) {
                    result.put("Ball..", result.get("Ball..") + 1);
                }
            }
        }
        pitchCall(result);
    }

    private void pitchCall(HashMap<String, Integer> pitchResult) {
        String resultMsg;
        String resultBallCount = "";
        String resultStrikeCount = "";

        if (pitchResult.get("Ball..") != 0) {
            resultBallCount = pitchResult.get("Ball..") + "Ball..";
        }

        if (pitchResult.get("Strike!") != 0) {
            resultStrikeCount += " " + pitchResult.get("Strike!") + "Strike!";
            if (pitchResult.get("Strike!") == 3) {
                resultStrikeCount += "\n3개의 숫자를 모두 맞췄습니다.! The End";
            }
        }

        resultMsg = resultBallCount + resultStrikeCount;
        if (resultMsg.isEmpty()) {
            resultMsg = "Nothing";
        }

        if (pitchResult.get("Strike!") == 3) {
            bCorrect = true;
        }
        System.out.println(resultMsg.trim());
    }
}