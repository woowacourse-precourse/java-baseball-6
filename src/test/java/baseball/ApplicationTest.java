package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("사용자 숫자 입력 정상처리 테스트")
    @Test
    void userNumberListRangeTest() {
        // given
        final int size = 3;
        final String input1 = "123";
        final String input2 = "456";

        // when
        final Throwable throwable1 = catchThrowable(() -> {
            Player.isValidInput(input1, size);
        });
        final Throwable throwable2 = catchThrowable(() -> {
            Player.isValidInput(input2, size);
        });

        // then
        assertThat(throwable1).doesNotThrowAnyException();
        assertThat(throwable2).doesNotThrowAnyException();
    }

    @DisplayName("사용자 숫자 입력 예외처리 테스트 - 범위")
    @Test
    void userNumberListRangeExceptionTest() {
        // given
        final int size = 3;
        final String input1 = "String";
        final String input2 = "12 3";
        final String input3 = "12!";
        final String input4 = "abcd7";

        // when
        final Throwable throwable1 = catchThrowable(() -> {
            Player.isValidInput(input1, size);
        });
        final Throwable throwable2 = catchThrowable(() -> {
            Player.isValidInput(input2, size);
        });
        final Throwable throwable3 = catchThrowable(() -> {
            Player.isValidInput(input3, size);
        });
        final Throwable throwable4 = catchThrowable(() -> {
            Player.isValidInput(input4, size);
        });

        // then
        assertThat(throwable1)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자연수만 입력해야합니다.");
        assertThat(throwable2)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자연수만 입력해야합니다.");
        assertThat(throwable3)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자연수만 입력해야합니다.");
        assertThat(throwable4)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자연수만 입력해야합니다.");
    }

    @DisplayName("사용자 숫자 입력 예외처리 테스트 - 숫자 개수")
    @Test
    void userNumberListSizeExceptionTest() {
        // given
        final int size = 3;
        final String input1 = "1";
        final String input2 = "22";
        final String input3 = "4444";
        final String input4 = "55555";

        // when
        final Throwable throwable1 = catchThrowable(() -> {
            Player.isValidInput(input1, size);
        });
        final Throwable throwable2 = catchThrowable(() -> {
            Player.isValidInput(input2, size);
        });
        final Throwable throwable3 = catchThrowable(() -> {
            Player.isValidInput(input3, size);
        });
        final Throwable throwable4 = catchThrowable(() -> {
            Player.isValidInput(input4, size);
        });

        // then
        assertThat(throwable1)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세 개의 수를 입력해야합니다.");
        assertThat(throwable2)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세 개의 수를 입력해야합니다.");
        assertThat(throwable3)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세 개의 수를 입력해야합니다.");
        assertThat(throwable4)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세 개의 수를 입력해야합니다.");
    }

    @DisplayName("사용자 숫자 입력 예외처리 테스트 - 중복")
    @Test
    void userNumberListDuplicationExceptionTest() {
        // given
        final int size = 3;
        final String input1 = "111";
        final String input2 = "112";
        final String input3 = "121";
        final String input4 = "122";

        // when
        final Throwable throwable1 = catchThrowable(() -> {
            Player.isValidInput(input1, size);
        });
        final Throwable throwable2 = catchThrowable(() -> {
            Player.isValidInput(input2, size);
        });
        final Throwable throwable3 = catchThrowable(() -> {
            Player.isValidInput(input3, size);
        });
        final Throwable throwable4 = catchThrowable(() -> {
            Player.isValidInput(input4, size);
        });

        // then
        assertThat(throwable1)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 수를 입력했습니다.");
        assertThat(throwable2)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 수를 입력했습니다.");
        assertThat(throwable3)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 수를 입력했습니다.");
        assertThat(throwable4)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 수를 입력했습니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
