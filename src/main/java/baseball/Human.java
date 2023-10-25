package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Human {

    private static final List<Integer> balls = new ArrayList<>();
    private int decision = 0;

    private static final int BALLS_SIZE = 3;
    private static final int RESTART_DECISION = 1;
    private static final int END_DECISION = 2;

    public void chooseBalls() {
        clearBalls();

        String input = Console.readLine();

        validateBalls(input);
    }

    public int getBall(int i) {
        return balls.get(i);
    }

    public void clearBalls() {
        balls.clear();
    }

    public void decideGameRestart() {
        String input = Console.readLine();

        validateDecision(input);
    }

    public int getDecision() {
        return decision;
    }

    public void clearDecision() {
        decision = 0;
    }

    private void validateBalls(String input) {
        validateBallsSize(input);
        validateBallsValue(input);
    }

    private void validateBallsSize(String input) {
        if (input.length() != BALLS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBallsValue(String input) {
        for (Character ballChar : input.toCharArray()) {
            int ball = Character.getNumericValue(ballChar);

            if (ball < 1 || ball > 9 || balls.contains(ball)) {
                throw new IllegalArgumentException();
            } else {
                balls.add(ball);
            }
        }
    }

    private void validateDecision(String input) {
        int decision;
        try {
            decision = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (decision < RESTART_DECISION || decision > END_DECISION) {
            throw new IllegalArgumentException();
        }

        this.decision = decision;
    }
}
