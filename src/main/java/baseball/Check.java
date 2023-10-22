package baseball;

import java.util.List;

public class Check {
    public int countHits(List<Integer> computer, List<Integer> player) {
        int hist = 0;

        for (int i = 0; i < player.size(); i++) {
            if (computer.contains(player.get(i))) {
                hist++;
            }
        }
        return hist;
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

    public String Classification(List<Integer> computer, List<Integer> player) {
        int hits = countHits(computer, player);
        int strikes = countStrikes(computer, player);
        int balls = hits - strikes;
        String result;

        if (hits == 0) {
            result = "낫싱";
        } else if (strikes == 0) {
            result = balls + "볼";
        } else if (balls == 0) {
            result = strikes + "스트라이크";
        } else {
            result = balls + "볼 " + strikes + "스트라이크";
        }
        return result;
    }
}
