package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Umpire {
    private final List<Integer> strikeZone;
    private static boolean isCorrect;

    Umpire() {
        this.strikeZone = MakeStrikeZone();
        isCorrect = false;
    }

    public static boolean IsCorrect() {
        return isCorrect;
    }

    private static List<Integer> MakeStrikeZone() {
        List<Integer> strikeZone = new ArrayList<>();

        while (strikeZone.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!strikeZone.contains(randomNumber)) {
                strikeZone.add(randomNumber);
            }
        }
        return strikeZone;
    }

    public void Pitch(List<Integer> guess) {
        HashMap<String, Integer> result = new HashMap<>();
        result.put("스트라이크", 0);
        result.put("볼", 0);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j && strikeZone.get(i).equals(guess.get(j))) {
                    result.put("스트라이크", result.get("스트라이크") + 1);
                }
                if (i != j && strikeZone.get(i).equals(guess.get(j))) {
                    result.put("볼", result.get("볼") + 1);
                }
            }
        }
        PitchCall(result);
    }

    private void PitchCall(HashMap<String, Integer> pitchResult) {
        //결과 출력
        String resultMsg;
        String resultBallCount = "";
        String resultStrikeCount = "";

        if (pitchResult.get("볼") != 0) {
            resultBallCount = pitchResult.get("볼") + "볼";
        }

        if (pitchResult.get("스트라이크") != 0) {
            resultStrikeCount += " " + pitchResult.get("스트라이크") + "스트라이크";
            if (pitchResult.get("스트라이크") == 3) {
                resultStrikeCount += "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
            }
        }
        resultMsg = resultBallCount + resultStrikeCount;
        if (resultMsg.isEmpty()) {
            resultMsg = "낫싱";
        }

        if (pitchResult.get("스트라이크") == 3) {
            isCorrect = true;
        }
        System.out.println(resultMsg.trim());
    }
}
