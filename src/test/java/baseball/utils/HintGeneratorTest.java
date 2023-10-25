package baseball.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.model.Hint;
import baseball.model.Numbers;
import java.util.List;
import org.junit.jupiter.api.Test;

class HintGeneratorTest {

    @Test
    public void 볼1_스트라이크1() {
        // given
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> player = List.of(1, 3, 8);

        // when
        Hint hint = HintGenerator.generate(Numbers.from(computer), Numbers.from(player));

        // then
        assertEquals("1볼 1스트라이크", hint.generateHintMessage());
    }

    @Test
    public void 볼2_스트라이크1() {
        // given
        List<Integer> computer = List.of(1, 8, 3);
        List<Integer> player = List.of(1, 3, 8);

        // when
        Hint hint = HintGenerator.generate(Numbers.from(computer), Numbers.from(player));

        // then
        assertEquals("2볼 1스트라이크", hint.generateHintMessage());
    }

    @Test
    public void 스트라이크3() {
        // given
        List<Integer> computer = List.of(1, 3, 8);
        List<Integer> player = List.of(1, 3, 8);

        // when
        Hint hint = HintGenerator.generate(Numbers.from(computer), Numbers.from(player));

        // then
        assertEquals("3스트라이크", hint.generateHintMessage());
    }

    @Test
    public void 낫싱() {
        // given
        List<Integer> computer = List.of(3, 1, 9);
        List<Integer> player = List.of(2, 4, 5);

        // when
        Hint hint = HintGenerator.generate(Numbers.from(computer), Numbers.from(player));

        // then
        assertEquals("낫싱", hint.generateHintMessage());
    }

    @Test
    public void 볼3() {
        // given
        List<Integer> computer = List.of(3, 1, 9);
        List<Integer> player = List.of(1, 9, 3);

        // when
        Hint hint = HintGenerator.generate(Numbers.from(computer), Numbers.from(player));

        // then
        assertEquals("3볼", hint.generateHintMessage());
    }
}