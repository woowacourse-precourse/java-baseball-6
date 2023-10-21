package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    @Test
    void 정답_생성_테스트() {
        // given

        // when
        Computer computer = new Computer();

        // then
        assertThat(computer.getAnswer()).hasSize(3);
    }

    @Test
    void 비교_로직_테스트_3스트라이크() {
        // given
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> input = List.of(1, 2, 3);
        Computer computer = new Computer(answer);

        // when
        List<Integer> result = computer.compareWithAnswer(input);

        // then
        assertThat(result).containsExactly(3, 0);
    }

    @Test
    void 비교_로직_테스트_3볼() {
        // given
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> input = List.of(2, 3, 1);
        Computer computer = new Computer(answer);

        // when
        List<Integer> result = computer.compareWithAnswer(input);

        // then
        assertThat(result).containsExactly(0, 3);
    }

    @Test
    void 비교_로직_테스트_1스트라이크_1볼() {
        // given
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> input = List.of(1, 3, 4);
        Computer computer = new Computer(answer);

        // when
        List<Integer> result = computer.compareWithAnswer(input);

        // then
        assertThat(result).containsExactly(1, 1);
    }

}
