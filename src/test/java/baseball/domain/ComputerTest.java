package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.dto.GameResult;
import baseball.util.NumberGenerator;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @DisplayName("Computer와 Player의 세 자리 숫자의 위치와 값이 모두 같으면, GameResult의 strike는 3이다.")
    @Test
    void gameResultStrikeIsThreeWhenAllNumbersAndPositionsMatch() {
        // given
        NumberGenerator fixedNumberGenerator = new FixedNumberGenerator(new ArrayDeque<>(List.of(2, 4, 6)));
        ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator(fixedNumberGenerator);

        // when
        Player player = Player.of(new ArrayList<>(List.of(2, 4, 6)));
        Computer computer = computerNumberGenerator.create();
        GameResult gameResult = computer.calculateAndReturnGameResult(player);

        // then
        assertThat(gameResult.strike()).isEqualTo(3);
        assertThat(gameResult.isThreeStrikes()).isEqualTo(true);
        assertThat(gameResult.ball()).isEqualTo(0);
    }

    @DisplayName("Computer와 Player의 세 자리 숫자의 값이 모두 같고 위치는 모두 다르면, GameResult의 ball은 3이다.")
    @Test
    void gameResultBallIsThreeWhenAllNumbersMatchButPositionsDiffer() {
        // given
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(new ArrayDeque<>(List.of(7, 8, 9)));
        ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator(fixedNumberGenerator);

        // when
        Player player = Player.of(new ArrayList<>(List.of(8, 9, 7)));
        Computer computer = computerNumberGenerator.create();
        GameResult gameResult = computer.calculateAndReturnGameResult(player);

        // then
        assertThat(gameResult.ball()).isEqualTo(3);
        assertThat(gameResult.strike()).isEqualTo(0);
        assertThat(gameResult.isThreeStrikes()).isEqualTo(false);
    }

    @DisplayName("Computer와 Player의 세 자리 숫자의 값과 위치가 모두 다르면, GameResult의 strike와 ball은 0이다.")
    @Test
    void gameResultStrikeAndBallAreZeroWhenAllNumbersAndPositionsDiffer() {
        // given
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(new ArrayDeque<>(List.of(3, 6, 5)));
        ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator(fixedNumberGenerator);

        // when
        Player player = Player.of(new ArrayList<>(List.of(1, 2, 4)));
        Computer computer = computerNumberGenerator.create();
        GameResult gameResult = computer.calculateAndReturnGameResult(player);

        // then
        assertThat(gameResult.ball()).isEqualTo(0);
        assertThat(gameResult.strike()).isEqualTo(0);
        assertThat(gameResult.isThreeStrikes()).isEqualTo(false);
    }
}