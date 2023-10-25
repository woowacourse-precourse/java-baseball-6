package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Objects;

public class Game {
    private final int GOAL;
    private List<Integer> computer;
    private List<Integer> user;
    int strike;
    int ball;


    public Game(final int gameSize) {
        GOAL = gameSize;
    }

    public void init(final int startInclusive, final int endInclusive) {
        computer = NumberGenerator.makeNumbers(startInclusive, endInclusive, GOAL);
        strike = -1;
        ball = -1;
    }

    public void play() {
        do {
            Message.input();
            String input = Console.readLine();
            user = InputParser.getUserNumbers(input, GOAL);
            strike = countStrike(user, computer);
            ball = countBall(user, computer, strike);
            Message.call(strike, ball);
        } while (!isFinish(strike));
        Message.end();
    }

    private boolean isFinish(int strike) {
        return strike == GOAL;
    }

    public int countStrike(List<Integer> user, List<Integer> computer) {
        int strike = 0;
        for (int i = 0; i < user.size(); i++) {
            if (Objects.equals(user.get(i), computer.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public int countBall(List<Integer> user, List<Integer> computer, final int strike) {
        int ball = 0;
        for (Integer integer : user) {
            if (computer.contains(integer)) {
                ball++;
            }
        }
        return ball - strike;
    }
}
