package hint;

import java.util.List;

public class Hint {
    public static int[] calculateStrikeAndBall(
            List<Integer> computerBaseballNumber, List<Integer> playerBaseballNumber) {
        
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < computerBaseballNumber.size(); i++) {
            if (computerBaseballNumber.get(i).equals(playerBaseballNumber.get(i))) {
                strike++;
                continue;
            }

            if (computerBaseballNumber.contains(playerBaseballNumber.get(i))) {
                ball++;
            }
        }

        return new int[]{strike, ball};
    }
}
