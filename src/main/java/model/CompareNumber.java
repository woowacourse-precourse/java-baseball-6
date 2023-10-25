package model;

import model.BallStrikeNothing;

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

    public void CompareComputerAndUser() {

        ballStrikeNothing.strike = StrikeCount();
        ballStrikeNothing.ball = BallCount();
        ballStrikeNothing.nothing = NothingCount();

        List<Integer> result = List.of(ballStrikeNothing.ball, ballStrikeNothing.strike, ballStrikeNothing.nothing);
    }

    public int StrikeCount() {
        return (int) IntStream.range(0, user.size())
                .filter(i -> computer.get(i).equals(user.get(i)))
                .count();
    }

    public int BallCount() {
        return (int) IntStream.range(0, user.size())
                .filter(i -> computer.contains(user.get(i)))
                .count() - ballStrikeNothing.strike;
    }

    public int NothingCount() {
        return 3 - ballStrikeNothing.strike - ballStrikeNothing.ball;
    }
}
