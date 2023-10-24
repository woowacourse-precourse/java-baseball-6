package baseball.play;

import static baseball.util.Constant.BALL;
import static baseball.util.Constant.NOTHING;
import static baseball.util.Constant.STRIKE;

import java.util.List;

public class Hint {
    /* 힌트 생성 로직 구현 */
    public static String evaluateGuess(Player player, Computer computer) {
        List<Integer> userNumbers = player.getNumbers();
        List<Integer> computerNumbers = computer.getNumbers();

        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            int userDigit = userNumbers.get(i);
            int computerDigit = computerNumbers.get(i);

            if (userDigit == computerDigit) {
                strikes++;
            } else if (computerNumbers.contains(userDigit)) {
                balls++;
            }
        }

        return buildResult(strikes, balls);
    }

    /* 힌트 로직 기반 출력 메서드 */
    private static String buildResult(int strikes, int balls) {
        StringBuilder result = new StringBuilder();

        if (balls > 0) {
            result.append(balls + BALL);
        }

        if (strikes > 0) {
            if (balls > 0) {
                result.append(" ");
            }
            result.append(strikes + STRIKE);
        }

        if (strikes == 0 && balls == 0) {
            result.append(NOTHING);
        }
        return result.toString();
    }
}
