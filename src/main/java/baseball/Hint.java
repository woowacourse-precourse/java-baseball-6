package baseball;

import java.util.List;

public class Hint {
    public static void provideHint(List<Integer> randomNumbers, int[] userGuess) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (userGuess[i] == randomNumbers.get(i)) {
                strikes++;
            } else if (randomNumbers.contains(userGuess[i])) {
                balls++;
            }
        }

        StringBuilder hint = new StringBuilder();
        if (balls > 0) {
            hint.append(balls).append("볼").append(" ");
        }
        if (strikes > 0) {
            hint.append(strikes).append("스트라이크").append(" ");
        }
        if (strikes == 0 && balls == 0) {
            hint.append("낫싱").append(" ");
        }
        hint.deleteCharAt(hint.length() - 1);

        System.out.println(hint);
    }
}
