package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;

import static baseball.Application.BaseBallGame;
import static baseball.Application.main;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    private final InputStream standardIn = System.in;

    @Test
    void makeBaseBallGameObject() {
        BaseBallGame baseBallGame = new BaseBallGame();
        assertThat(baseBallGame).isNotNull();
    }

    @Test
    void Should_ReturnCorrectRandomNumbers_When_MakeRandomNumbers() {
        // given
        BaseBallGame baseBallGame = new BaseBallGame();

        // when
        List<Integer> computerNumbers = baseBallGame.getComputerNumbers();
        HashSet<Integer> computerNumbersSet = new HashSet<>(computerNumbers);

        // then
        for (Integer computerNumber : computerNumbers) {
            assertThat(computerNumber).isPositive()
                    .isLessThanOrEqualTo(9);
        }
        assertThat(computerNumbersSet).hasSameSizeAs(computerNumbers);
    }

    @Test
    void Should_ThrowIllegalArgumentException_When_EnterIncorrectUserNumbers() {
        // given
        System.setIn(new ByteArrayInputStream("12*".getBytes()));
        BaseBallGame baseBallGame = new BaseBallGame();

        // when
        Throwable thrown = catchThrowable(() -> baseBallGame.playGame());
        System.setIn(standardIn);

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 수가 입력되었습니다.");
    }

    @Test
    void Should_Success_When_EnterCorrectUserNumbers() {
        // given
        System.setIn(new ByteArrayInputStream("124".getBytes()));
        BaseBallGame baseBallGame = new BaseBallGame();

        // when
        baseBallGame.playGame();
        List<Integer> userNumbers = baseBallGame.getUserNumbers();
        System.setIn(standardIn);

        // then
        assertThat(userNumbers).usingRecursiveComparison().isEqualTo(List.of(1, 2, 4));
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
        main(new String[]{});
    }
}
