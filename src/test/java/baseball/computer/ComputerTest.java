package baseball.computer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    Computer computer;
    GameNumbers answer;

    @BeforeEach
    void setComputer() {
        computer = new Computer();
        answer = computer.generateAnswer();
    }

    @DisplayName("정답은 임의의 3자리 수여야 한다.")
    @Test
    void 정답_자리수_테스트() {
        //then
        assertThat(answer.size()).isEqualTo(3);
    }

    @DisplayName("정답은 1~9사이의 숫자로 이루어져 있어야 한다.")
    @Test
    void 정답_숫자_범위_테스트() {
        //given
        List<Integer> target = new ArrayList<>();

        //when
        for (int i = 0; i < answer.size(); i++) {
            target.add(answer.getNumberByIndex(i));
        }

        //then
        assertThat(target.stream()
                .allMatch(v -> 1 <= v && v <= 9))
                .isTrue();
    }
}
