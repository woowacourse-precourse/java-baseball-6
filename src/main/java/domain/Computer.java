package domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer {
    public static final int LENGTH = 3;
    private List<Integer> computerNumbers = new ArrayList<>();
    private Map<String, Integer> result = new HashMap<>();

    public void createComputerNumbers() {
        computerNumbers.clear();
        while (computerNumbers.size() < LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    public Map<String, Integer> countAndGetResult(Player player) {
        List<Integer> playerNumbers = player.playerNumbers;
        int strike = 0;
        int ball = 0;
        for (int i=0;i<computerNumbers.size();i++) {
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strike++;
            }
        }
        for (int i=0;i<computerNumbers.size();i++) {
            if (computerNumbers.contains(playerNumbers.get(i))) {
                ball++;
            }
        }
        result.put("strike", strike);
        result.put("ball", ball - strike);
        if (strike==computerNumbers.size()) {
            player.isWin = true;
        }
        return result;
    }
}
