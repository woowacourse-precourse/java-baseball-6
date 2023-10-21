package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    @Disabled
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    @Disabled
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("컴퓨터 랜덤 번호 갯수 테스트")
    @Test
    void computerNumberSizeTest() {
        // given
        final int size = 3;

        // when
        final List<Integer> computerNumberList = Game.createNumbers(size);

        // then
        assertThat(computerNumberList.size()).isEqualTo(size);
    }

    @DisplayName("컴퓨터 랜덤 번호 범위 테스트")
    @Test
    void computerNumberRangeTest() {
        // given
        final int size = 3;

        // when
        final List<Integer> computerNumberList = Game.createNumbers(size);

        // then
        assertThat(computerNumberList.stream().allMatch(v -> v >= 1 && v <= 9)).isTrue();
    }

    @DisplayName("컴퓨터 랜덤 번호 중복 체크")
    @Test
    void computerNumberDuplicationTest() {
        // given
        final int size = 3;

        // when
        final List<Integer> computerNumberList = Game.createNumbers(size);

        // then
        assertThat(computerNumberList.size()).isEqualTo(new HashSet<>(computerNumberList).size());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
