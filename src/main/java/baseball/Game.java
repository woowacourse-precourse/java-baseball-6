package baseball;

import java.util.List;

public class Game {
    private int ball = 0;
    private int strike = 0;

    public void numCompare(int computerNumber, int userNumber, int i, int j) {
        if (computerNumber == userNumber) {
            indexCompare(i, j);
        }
    }

    public void indexCompare(int i, int j) {
        if (i == j) {
            strike += 1;
        } else {
            ball += 1;
        }
    }

    public void listCompare(List<Integer> computerNum, List<Integer> userNum) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                numCompare(computerNum.get(i), userNum.get(j), i, j);
            }
        }
    }
}
