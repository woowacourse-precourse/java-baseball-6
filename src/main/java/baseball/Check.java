package baseball;

import java.util.List;

public class Check {
    public int countHits(List<Integer> computer, List<Integer> player) {
        int hits = 0;

        for (int i = 0; i < player.size(); i++) {
            if (computer.contains(player.get(i))) {
                hits++;
            }
        }

        return hits;
    }

    public int countStrikes(List<Integer> computer, List<Integer> player) {
        int strikes = 0;

        for (int i = 0; i < player.size(); i++) {
            if (computer.get(i).equals(player.get(i))) {
                strikes++;
            }
        }

        return strikes;
    }

    public String classifyResult(List<Integer> computer, List<Integer> player) {
        int hits = countHits(computer, player);
        int strikes = countStrikes(computer, player);
        int balls = hits - strikes;

        if (strikes == 0) {
            if (balls == 0) {
                return "낫싱";
            } else {
                return balls + "볼";
            }
        } else if (balls == 0) {
            return strikes + "스트라이크";
        } else {
            return balls + "볼" + strikes + "스트라이크";
        }
    }
}
