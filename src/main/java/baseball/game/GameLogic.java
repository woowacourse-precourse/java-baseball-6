package baseball.game;

import baseball.user.UserStatus;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameLogic {

    public GameLogic() {
    }


    public int countStrike(String userNumber, ArrayList<Integer> computerNumber) {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            if (userNumber.charAt(i) - 48 == computerNumber.get(i)) {
                result++;
            }
        }
        return result;
    }

    public int countBall(String userNumber, ArrayList<Integer> computerNumber) {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            if (userNumber.charAt(i) - 48 != computerNumber.get(i) && computerNumber.contains(
                userNumber.charAt(i) - 48)) {
                result++;
            }
        }
        return result;
    }

    boolean isNothing(int strike, int ball) {
        return strike == 0 && ball == 0;
    }

    boolean isAnswer(String hint) {
        return hint.equals(GameHintType.ANSWER.toString());
    }

    String generateHintFromResult(int strike, int ball) {
        if (isNothing(strike, ball)) {
            return GameHintType.NOTHING.format(0);
        }

        return combineStrikeAndBallHints(strike, ball);
    }

    private String combineStrikeAndBallHints(int strike, int ball) {
        return Stream.of(GameHintType.BALL.format(ball), GameHintType.STRIKE.format(strike))
            .filter(hint -> !hint.isEmpty())
            .collect(Collectors.joining(" "));
    }

    public boolean isQuitGame(String userStatus) {
        return userStatus.equals(UserStatus.EXIT_COMMAND);
    }
}
