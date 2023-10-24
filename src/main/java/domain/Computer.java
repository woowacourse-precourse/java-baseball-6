package domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer {
    public static final int LENGTH = 3;

    public static boolean isPlayerWin;
    private List<Integer> computerNumbers = new ArrayList<>();

    public void createComputerNumbers() {
        isPlayerWin = false;
        computerNumbers.clear();
        while (computerNumbers.size() < LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    public Map<String, Integer> getResult(List<Integer> playerNumbers) {
        Map<String, Integer> result = new HashMap<>();
        result.put("strike", countStrikeCnt(playerNumbers));
        result.put("ball", countBallCnt(playerNumbers));
        if (result.get("strike") == LENGTH) {
            isPlayerWin = true;
        }
        return result;
    }

    private int countStrikeCnt(List<Integer> playerNumbers) {
        int cnt = 0;
        for (int i = 0; i < computerNumbers.size(); i++) {
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                cnt++;
            }
        }
        return cnt;
    }

    private int countBallCnt(List<Integer> playerNumbers) {
        int cnt = 0;
        for (int i = 0; i < computerNumbers.size(); i++) {
            if (computerNumbers.contains(playerNumbers.get(i)) &&
                !computerNumbers.get(i).equals(playerNumbers.get(i))) {
                cnt++;
            }
        }
        return cnt;
    }
}
