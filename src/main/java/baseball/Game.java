package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public final List<Integer> score = new ArrayList<>();
    public final int BALL = 0;
    public final int STRIKE = 1;

    public void numCompare(char computerNumber, char userNumber, int i, int j) {
        if (computerNumber == userNumber) {
            indexCompare(i, j);
        }
    }

    public void indexCompare(int i, int j) {
        if (i == j) {
            score.set(STRIKE, score.get(STRIKE) + 1);
        } else {
            score.set(BALL, score.get(BALL) + 1);
        }
    }

    public void listCompare(List<Character> computerNum, String userNum) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                numCompare(computerNum.get(i), userNum.charAt(j), i, j);
            }
        }
    }

    public void clear() {
        score.clear();
        score.add(0);
        score.add(0);
    }
}
