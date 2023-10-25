package baseball.games.numberbaseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.games.numberbaseball.enums.PlayerOption;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {
    @Test
    @DisplayName("플레이어의 알맞은 문자열 입력이 리스트 형태로 변환되어 리턴")
    void generatePlayerNumbers() {
        //given
        NumberGenerator generator = new NumberGenerator();
        //when
        List<Integer> numbers = generator.createValidatedNumbers("124");
        //then
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers).containsExactly(1, 2, 4);
    }

    @Test
    @DisplayName("플레이어가 다시 게임을 하길 선택한 경우 PlayerOption.RESTART를 반환")
    void playerWantRestart() {
        //given
        NumberGenerator generator = new NumberGenerator();
        //when
        String input = "1";
        //then
        assertThat(generator.createValidatedOption(input)).isEqualTo(PlayerOption.RESTART);
    }

    @Test
    @DisplayName("플레이어가 게임 종료를 선택한 경우 PlayerOption.END를 반환")
    void playerWantEnd() {
        //given
        NumberGenerator generator = new NumberGenerator();
        //when
        String input = "2";
        //then
        assertThat(generator.createValidatedOption(input)).isEqualTo(PlayerOption.END);
    }
}