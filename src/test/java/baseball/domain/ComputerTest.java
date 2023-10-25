package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    @Test
    void 컴퓨터_난수_생성() {
        Computer computer = new Computer();
        assertThat(computer.generateRandomNumbers().size()).isEqualTo(3);
    }

    @Test
    void 난수_중복_테스트() {
        Computer computer = new Computer();

        Map<Integer, Integer> computerMap = computer.generateRandomNumbers().stream()
                .collect(Collectors.toMap(number -> number, number -> number));
        assertThat(computerMap.size()).isEqualTo(3);
    }
}
