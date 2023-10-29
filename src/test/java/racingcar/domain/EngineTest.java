package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.domain.numbergenerator.SetNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.stream.IntStream;

class EngineTest {
    @Test
    void 이동_가능_검사() {
        IntStream.rangeClosed(4, 9).forEach(setNumber -> {

            Engine engine = new Engine(new SetNumberGenerator(setNumber));

            assertThat(engine.canMove()).isTrue();
        });
    }
    @Test
    void 이동_불가능_검사() {
        IntStream.rangeClosed(0, 3).forEach(setNumber -> {

            Engine engine = new Engine(new SetNumberGenerator(setNumber));

            assertThat(engine.canMove()).isFalse();
        });
    }
}
