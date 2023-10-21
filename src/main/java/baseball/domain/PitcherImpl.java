package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PitcherImpl implements Pitcher {

    private static class PitchPositionMaker {

        private static List<Integer> generatePositions() {
            Set<Integer> generatedPositions = new LinkedHashSet<>();
            while (generatedPositions.size() < BaseballGame.BALL_COUNT) {
                generatedPositions.add(generateRandomPosition());
            }

            return new ArrayList<>(generatedPositions);
        }

        private static int generateRandomPosition() {
            return Randoms.pickNumberInRange(Baseball.MIN_POSITION, Baseball.MAX_POSITION);
        }
    }

    @Override
    public List<Baseball> pitchBalls() {
        List<Integer> pitchPositions = PitchPositionMaker.generatePositions();

        return IntStream.range(0, BaseballGame.BALL_COUNT)
                .mapToObj(pitchOrder -> Baseball.of(pitchOrder, pitchPositions.get(pitchOrder)))
                .collect(Collectors.toList());
    }
}
