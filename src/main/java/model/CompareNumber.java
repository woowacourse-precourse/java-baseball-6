package model;

import java.util.List;
import java.util.stream.IntStream;

public class CompareNumber {
    private BallStrikeNothing ballStrikeNothing;

    List<Integer> user;
    List<Integer> computer;

    public CompareNumber(List<Integer> user, List<Integer> computer) {
        this.user = user;
        this.computer = computer;
    }

    public void compareComputerAndUser() {

        ballStrikeNothing.strike = strikeCount();
        ballStrikeNothing.ball = ballCount();
        ballStrikeNothing.nothing = nothingCount();

        List<Integer> result = List.of(ballStrikeNothing.ball, ballStrikeNothing.strike, ballStrikeNothing.nothing);
    }

    public int strikeCount() {
        return (int) IntStream.range(0, user.size())
                .filter(i -> computer.get(i).equals(user.get(i)))
                .count();
    }

    public int ballCount() {
        return (int) IntStream.range(0, user.size())
                .filter(i -> computer.contains(user.get(i)))
                .count() - ballStrikeNothing.strike;
    }

    public int nothingCount() {
        return 3 - ballStrikeNothing.strike - ballStrikeNothing.ball;
    }
}
