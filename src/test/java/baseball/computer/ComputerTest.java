package baseball.computer;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.game.Computer;
import baseball.game.GameNumbers;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        List<Integer> target = answer.getNumbers();

        //then
        assertThat(target.stream()
                .allMatch(v -> 1 <= v && v <= 9))
                .isTrue();
    }

    @DisplayName("정답은 중복된 숫자가 없어야 한다.")
    @Test
    void 정답_중복_숫자_테스트() {
        //given
        Set<Integer> target = new HashSet<>(answer.getNumbers());

        //then
        assertThat(target.size()).isEqualTo(answer.size());
    }
}
