package baseball.domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.FixedNumberGenerator;
import baseball.domain.dto.GameResultDTO;
import baseball.util.Err;
import baseball.util.NumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @DisplayName("Computer의 세 자리 숫자가 1 ~ 9 사이에 없으면 예외 발생")
    @Test
    void validateGameNumber_OutOfRange_Exception() {
        // given
        List<Integer> numbers = List.of(-11, 0, 30);

        // when
        // then
        assertThatThrownBy(() -> Computer.of(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Err.OUT_OF_RANGE_NUMBERS.getMessage());
    }

    @DisplayName("Computer가 세 자리 숫자를 가지지 않으면 예외 발생")
    @Test
    void validateSize_NotThree_Exception() {
        // given
        List<Integer> numbers1 = List.of(4, 2, 3, 1);
        List<Integer> numbers2 = List.of(9, 1);

        // when
        // then
        assertThatThrownBy(() -> Computer.of(numbers1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Err.INVALID_NUMBERS_SIZE.getMessage());

        assertThatThrownBy(() -> Computer.of(numbers2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Err.INVALID_NUMBERS_SIZE.getMessage());
    }

    @DisplayName("Computer의 세 자리 숫자가 중복이면 예외 발생")
    @Test
    void validateDuplication_NotUnique_Exception() {
        // given
        List<Integer> numbers = List.of(8, 7, 8);

        // when
        // then
        assertThatThrownBy(() -> Computer.of(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Err.DUPLICATE_NUMBERS.getMessage());
    }

    @DisplayName("Computer와 Player의 세 자리 숫자의 위치와 값이 모두 같으면, GameResult의 strike는 3이다.")
    @Test
    void evaluateWith_AllMatches_ThreeStrikes() {
        // given
        NumberGenerator fixedNumberGenerator = new FixedNumberGenerator(List.of(1, 2, 3));
        ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator(fixedNumberGenerator);

        // when
        Computer computer = computerNumberGenerator.create();
        Player player = Player.of(List.of(1, 2, 3));
        GameResultDTO gameResultDTO = computer.evaluateWith(player);

        // then
        assertThat(gameResultDTO.ball()).isEqualTo(0);
        assertThat(gameResultDTO.strike()).isEqualTo(3);
        assertThat(gameResultDTO.isThreeStrikes()).isEqualTo(true);
    }

    @DisplayName("Computer와 Player의 세 자리 숫자의 값이 모두 같고 위치는 모두 다르면, GameResult의 ball은 3이다.")
    @Test
    void evaluateWith_AllContains_ThreeBalls() {
        // given
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(List.of(7, 8, 9));
        ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator(fixedNumberGenerator);

        // when
        Computer computer = computerNumberGenerator.create();
        Player player = Player.of(List.of(8, 9, 7));
        GameResultDTO gameResultDTO = computer.evaluateWith(player);

        // then
        assertThat(gameResultDTO.ball()).isEqualTo(3);
        assertThat(gameResultDTO.strike()).isEqualTo(0);
        assertThat(gameResultDTO.isThreeStrikes()).isEqualTo(false);
    }

    @DisplayName("Computer와 Player의 세 자리 숫자의 값과 위치가 모두 다르면, GameResult의 strike와 ball은 0이다.")
    @Test
    void evaluateWith_AllDiffers_AllZero() {
        // given
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(List.of(3, 6, 5));
        ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator(fixedNumberGenerator);

        // when
        Computer computer = computerNumberGenerator.create();
        Player player = Player.of(List.of(1, 2, 4));
        GameResultDTO gameResultDTO = computer.evaluateWith(player);

        // then
        assertThat(gameResultDTO.ball()).isEqualTo(0);
        assertThat(gameResultDTO.strike()).isEqualTo(0);
        assertThat(gameResultDTO.isThreeStrikes()).isEqualTo(false);
    }
}