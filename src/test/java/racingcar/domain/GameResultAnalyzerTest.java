package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameResultAnalyzerTest {
    List<RacingCar> racingCars = new ArrayList<>();

    @BeforeEach
    void setUp() {
        racingCars.add(new RacingCar("LEE"));
        racingCars.add(new RacingCar("SANG"));
        racingCars.add(new RacingCar("HYUN"));
    }

    @Test
    void 우승자_찾기_테스트() {
        while (racingCars.get(1).getLocation() < 2) {
            racingCars.get(1).moveRandom();
        }
        List<RacingCar> winners = GameResultAnalyzer.findWinners(racingCars);

        assertThat(winners.get(0).name).isEqualTo("SANG");
    }
    @Test
    void 우승자_찾기_테스트_공동우승() {
        while (racingCars.get(0).getLocation() < 2) {
            racingCars.get(0).moveRandom();
        }
        while (racingCars.get(1).getLocation() < 2) {
            racingCars.get(1).moveRandom();
        }
        while (racingCars.get(2).getLocation() < 1) {
            racingCars.get(2).moveRandom();
        }
        HashSet<String> winnersNameList = new HashSet<>(GameResultAnalyzer.findWinners(racingCars)
                .stream().map(RacingCar::getName).toList());

        assertThat(winnersNameList).isEqualTo(new HashSet<>(Arrays.asList("SANG", "LEE")));
    }
}
