package baseball.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
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

    @DisplayName("숫자는 같지만 자리가 다른 경우 볼")
    @Test
    void 볼_판단_테스트() {
        //given
        List<Integer> target = answer.getNumbers();
        int number1 = answer.getNumberByIndex(0);
        int number2 = answer.getNumberByIndex(1);
        int number3 = answer.getNumberByIndex(2);
        GameNumbers user = new GameNumbers(List.of(number3, number1, number2));

        //when
        Hint hint = computer.getHint(user);

        //then
        Assertions.assertThat(hint.getBall()).isEqualTo(3);
    }

    @DisplayName("숫자와 자리가 모두 같으면 스트라이크")
    @Test
    void 스트라이크_판단_테스트() {
        //given
        List<Integer> target = answer.getNumbers();
        int number1 = answer.getNumberByIndex(0);
        int number2 = answer.getNumberByIndex(1);
        int number3 = answer.getNumberByIndex(2);
        GameNumbers user = new GameNumbers(List.of(number1, number3, number2));

        //when
        Hint hint = computer.getHint(user);

        //then
        Assertions.assertThat(hint.getStrike()).isEqualTo(1);
    }

    @DisplayName("볼, 스트라이크 종합 테스트")
    @Test
    void 볼_스트라이크_판단_테스트() {
        //given
        List<Integer> target = answer.getNumbers();
        int number1 = answer.getNumberByIndex(0);
        int number2 = answer.getNumberByIndex(1);
        int number3 = answer.getNumberByIndex(2);
        GameNumbers user = new GameNumbers(List.of(number1, number3, number2));

        //when
        Hint hint = computer.getHint(user);

        //then
        Assertions.assertThat(hint.getBall()).isEqualTo(2);
        Assertions.assertThat(hint.getStrike()).isEqualTo(1);
    }
}
