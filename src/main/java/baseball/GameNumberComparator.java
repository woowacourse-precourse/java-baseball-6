package baseball;

import java.util.List;

public class GameNumberComparator {
    public static int [] compareNumbers(List<Integer> computerNumber, List<Integer> userNumber){
        int [] game = {0, 0}; // strike, ball
        int strike = 0;
        int[] computerCount = new int[10];
        int[] userCount = new int[10];

        for (int i = 0; i < 3; i++) {

            computerCount[computerNumber.get(i)]++;
            userCount[userNumber.get(i)]++;
            if (computerNumber.get(i) == userNumber.get(i)) {
                strike++;
            }
        }

        // 볼
        int ball = 0;
        if (strike < 3) {
            for (int i = 1; i <= 9; i++) {
                if (userCount[i] > 0) {
                    ball += computerCount[i];
                }
            }
            ball -= strike;
        }
        game[0] = strike;
        game[1] = ball;
        return game;
    }

}
