package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class JudgementTest {

    @DisplayName("컴퓨터 수와 플레이어 수를 비교해 게임 결과를 판정한다.")
    @Test
    void judge() {
        // given
        Computer computer = new Computer(List.of(1, 2, 3));
        Judgement judgement = new Judgement(computer);
        Player player = new Player(List.of(3, 2, 1));

        // when
        judgement.judge(player);

        // then
        assertThat(judgement.getStrike()).isEqualTo(1);
        assertThat(judgement.getBall()).isEqualTo(2);
    }

    @DisplayName("게임 진행 상황을 확인한다.")
    @MethodSource("generateData")
    @ParameterizedTest
    void isProgress(Player player, boolean expected) {
        //given
        Computer computer = new Computer(List.of(1, 2, 3));
        Judgement judgement = new Judgement(computer);
        judgement.judge(player);

        //when
        boolean result = judgement.isProgress();

        //then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(new Player(List.of(1, 2, 3)), false),
                Arguments.of(new Player(List.of(1, 3, 2)), true)
        );
    }
}
