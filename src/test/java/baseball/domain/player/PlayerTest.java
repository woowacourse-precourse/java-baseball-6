package baseball.domain.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PlayerTest {
    private Player answerNumbers;
    @BeforeEach
    void beforeEach() {
        answerNumbers = Player.createPlayerByIntegerNumbers(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("4개 이상의 수가 입력될 경우 Exception이 발생해야 한다.")
    void checkExceptionByOutOfInputSize() {
        // given
        List<Integer> input = Arrays.asList(1, 2, 3, 4);

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Player.createPlayerByIntegerNumbers(input))
                .withMessageMatching("3개 이상의 공이 입력될 수 없습니다.");
    }
    @Test
    @DisplayName("3개의 수가 입력될 경우 정상적으로 생성되어야 한다.")
    public void createPlayerWithThreeNumbers() {
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3);

        // when
        Player player = Player.createPlayerByIntegerNumbers(inputNumbers);

        // then
        assertThat(player).isNotNull();
    }
    @Test
    @DisplayName("중복된 숫자가 입력될 경우 Exception이 발생해야 한다.")
    public void checkExceptionForDuplicateNumbers() {
        List<Integer> inputNumbers = Arrays.asList(1, 2, 2);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Player.createPlayerByIntegerNumbers(inputNumbers))
                .withMessage("중복된 숫자는 입력될 수 없습니다.");
    }

    @Test
    @DisplayName("중복된 숫자가 입력되지 않으면 정상적으로 생성되어야 한다.")
    public void createPlayerWithNonDuplicateNumbers() {
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3);

        // when
        Player player = Player.createPlayerByIntegerNumbers(inputNumbers);

        // then
        assertThat(player).isNotNull();
    }

    @Nested
    @DisplayName("[Strike 단일 계산 테스트]")
    class CaculateStrikeTest {

        @Test
        @DisplayName("스트라이크 수가 1개이면 스트라이크 수를 1개 반환할 수 있다.")
        void caculateOneStrike() {
            // given
            Player input = Player.createPlayerByIntegerNumbers(Arrays.asList(1, 4, 5));
            int expected = 1;
            // when
            int result = answerNumbers.calculateStrikeCounts(input);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("스트라이크 수가 2개이면 스트라이크 수를 2개 반환할 수 있다.")
        void calculateTwoStrike() {
            // given
            Player input = Player.createPlayerByIntegerNumbers(Arrays.asList(1, 2, 5));
            int expected = 2;

            // when
            int result = answerNumbers.calculateStrikeCounts(input);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("스트라이크 수가 3개이면 스트라이크 수를 3개 반환할 수 있다.")
        void calculateThreeStrike() {
            // given
            Player input = Player.createPlayerByIntegerNumbers(Arrays.asList(1, 2, 3));
            int expected = 3;

            // when
            int result = answerNumbers.calculateStrikeCounts(input);

            // then
            assertThat(result).isEqualTo(expected);
        }
    }
}