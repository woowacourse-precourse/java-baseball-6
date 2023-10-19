package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import hint.Hint;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import player.Player;

class ApplicationTest extends NsTest {
    private final static InputStream systemIn = System.in;

    @AfterEach
    void tearDown() {
        System.setIn(systemIn);
    }

    @Test
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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    @DisplayName("플레이어의 입력이 123인지 확인하는 테스트")
    public void 플레이어_입력_정상_테스트() {
        //given
        String playerInput = "123";
        Player player = new Player();
        System.setIn(new ByteArrayInputStream(playerInput.getBytes()));

        //when
        List<Integer> playerBaseballNumber = player.inputPlayerNumber();

        //then
        assertThat(playerBaseballNumber).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("올바르지 않은 입력시 IllegalArgumentException 발생하는지")
    public void 플레이어_입력_오류_테스트() {
        //given
        final String playerInput = "1234";
        final Player player = new Player();
        System.setIn(new ByteArrayInputStream(playerInput.getBytes()));

        //when, then
        assertThatThrownBy(player::inputPlayerNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리의 숫자만 입력가능합니다.");
    }

    @Test
    @DisplayName("심판이 strike와 ball개수를 정확히 판별하는지 테스트")
    public void 심판_스트라이크_볼_계산_테스트() {
        //given
        final List<Integer> computerBaseballNumber = List.of(1, 2, 3);
        final List<Integer> playerBaseballNumber = List.of(1, 4, 3);
        final int[] score = new int[]{2, 0};
        Hint hint = new Hint();

        //when
        int[] result = hint.calculateStrikeAndBall(computerBaseballNumber, playerBaseballNumber);

        //then
        assertThat(result).isEqualTo(score);
    }
}
