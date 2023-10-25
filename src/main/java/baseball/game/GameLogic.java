package baseball.game;

import baseball.user.UserStatus;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GameLogic {

    private static final int numberLength = 3;

    public GameLogic() {
    }


    public int countStrike(String userNumber, ArrayList<Integer> computerNumber) {
        return (int) IntStream.range(0, numberLength)
            .filter(i -> Character.getNumericValue(userNumber.charAt(i)) == computerNumber.get(i))
            .count();
    }

    public int countBall(String userNumber, ArrayList<Integer> computerNumber) {
        return (int) IntStream.range(0, numberLength)
            .filter(i -> Character.getNumericValue(userNumber.charAt(i)) != computerNumber.get(i)
                && computerNumber.contains(Character.getNumericValue(userNumber.charAt(i))))
            .count();
    }

    public boolean isNothing(int strike, int ball) {
        return strike == 0 && ball == 0;
    }

    public boolean isAnswer(String hint) {
        return hint.equals(GameHintType.ANSWER.toString());
    }

    public String generateHintFromResult(int strike, int ball) {
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
