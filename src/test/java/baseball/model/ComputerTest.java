package baseball.model;

import java.util.Arrays;
import java.util.List;

import baseball.util.StubNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class ComputerTest {

    private Computer computer;

    @BeforeEach
    void init() {
        computer = Computer.createWithGenerator(new StubNumberGenerator("123"));
    }

    @Test
    void 스트라이크갯수를_반환한다() {
        // given
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3);

        // when
        int strikeCount = computer.getStrikeCount(inputNumbers);

        // then
        Assertions.assertThat(strikeCount).isEqualTo(3);
    }

    @Test
    void 볼갯수를_반환한다() {
        // given
        List<Integer> inputNumbers = Arrays.asList(2, 3, 4);

        // when
        int ballCount = computer.getBallCount(inputNumbers);

        // then
        Assertions.assertThat(ballCount).isEqualTo(2);
    }

    @Test
    void 쓰리_스트라이크인지_확인한다() {
        // given
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3);

        // when
        boolean isThreeStrikes = computer.isThreeStrikes(inputNumbers);

        // then
        Assertions.assertThat(isThreeStrikes).isTrue();
    }
}
