package baseball.domain.baseballplayer.referee;

import baseball.domain.baseballplayer.dto.Ball;

import java.util.List;
import java.util.stream.IntStream;

public class Rule {
    private final int MIN_SIZE = 0;
    private List<Integer> offenseTeamNumbers;
    private List<Integer> defenseTeamNumbers;

    private Rule() {
    }

    public static Rule newInstance() {
        return new Rule();
    }

    public void setTeamsBallNumbers(final Ball defenseTeamBall, final Ball offenseTeamBall) {
        this.defenseTeamNumbers = defenseTeamBall.numbers();
        this.offenseTeamNumbers = offenseTeamBall.numbers();
    }

    public int calculateBallCount() {
        return (int) IntStream.range(MIN_SIZE, offenseTeamNumbers.size())
                .filter(i -> defenseTeamNumbers.contains(offenseTeamNumbers.get(i))
                        && !defenseTeamNumbers.get(i).equals(offenseTeamNumbers.get(i)))
                .count();
    }

    public int calculateStrikeCount() {
        return (int) IntStream.range(MIN_SIZE, offenseTeamNumbers.size())
                .filter(i -> offenseTeamNumbers.get(i).equals(defenseTeamNumbers.get(i)))
                .count();
    }

}
