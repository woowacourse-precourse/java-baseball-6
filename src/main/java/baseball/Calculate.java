package baseball;

import java.util.List;

public class Calculate {

    public int[] calculate(List<Integer> guess, List<Integer> answer) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (guess.get(i).equals(answer.get(i))) {
                strike++;
            } else if (answer.contains(guess.get(i))) {
                ball++;
            }
        }

        return new int[]{strike, ball};
    }
}
