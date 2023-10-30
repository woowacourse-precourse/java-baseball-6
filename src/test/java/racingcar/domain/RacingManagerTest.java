package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;
import org.junit.jupiter.api.*;
import racingcar.domain.numbergenerator.NumberGenerator;
import racingcar.domain.numbergenerator.SetNumberGenerator;

class RacingManagerTest {
    NumberGenerator successNumberGenerator = new SetNumberGenerator(5);
    NumberGenerator failureNumberGenerator = new SetNumberGenerator(0);
    String successInputName = "a,b,c,d";

    @Test
    void 이름_잘못된_입력_테스트() {
        String inputNames = "dave,paul,";

        assertThatThrownBy(() -> {
            new RacingManager(inputNames, 1, successNumberGenerator);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 횟수_입력_검증_테스트1() {
        assertThatThrownBy(() -> {
           new RacingManager(successInputName, 0, successNumberGenerator);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 횟수_입력_검증_테스트2() {
        assertThatThrownBy(() -> {
            new RacingManager(successInputName, -1, successNumberGenerator);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 경기_종료_테스트1() {
        RacingManager racingManager = new RacingManager(successInputName, 2, successNumberGenerator);

        racingManager.doAttempt();
        racingManager.doAttempt();

        assertThat(racingManager.isRaceEnd()).isTrue();
    }
    @Test
    void 경기_종료_테스트2() {
        RacingManager racingManager = new RacingManager(successInputName, 3, successNumberGenerator);

        racingManager.doAttempt();
        racingManager.doAttempt();

        assertThat(racingManager.isRaceEnd()).isFalse();
    }
    @Test
    void 차수_결과_테스트() {
        RacingManager racingManager = new RacingManager(successInputName, 4, successNumberGenerator);

        racingManager.doAttempt();

        Map<String, Integer> attemptResult = new HashMap<>(0);
        attemptResult.put("a", 1);
        attemptResult.put("b", 1);
        attemptResult.put("c", 1);
        attemptResult.put("d", 1);

        assertThat(racingManager.getAttemptResult()).isEqualTo(attemptResult);
    }
    @Test
    void 게임_승자_테스트() {
        RacingManager racingManager = new RacingManager(successInputName, 3, successNumberGenerator);

        racingManager.doAttempt();
        racingManager.doAttempt();
        racingManager.doAttempt();

        List<String> winner = new ArrayList<>(List.of(successInputName.split(",")));

        assertThat(racingManager.getWinners()).isEqualTo(winner);
    }
}
