package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

    @DisplayName("스트라이크 개수 세는 테스트")
    @Test
    void countStrikeTest() {
        // given
        final int size = 3;
        final List<Integer> computer = Arrays.asList(1, 3, 5);

        final List<Integer> user1 = Arrays.asList(2, 4, 8); // 0 strike

        final List<Integer> user2 = Arrays.asList(1, 7, 9); // 1 strike
        final List<Integer> user3 = Arrays.asList(2, 3, 8); // 1 strike
        final List<Integer> user4 = Arrays.asList(4, 7, 5); // 1 strike

        final List<Integer> user5 = Arrays.asList(1, 3, 9); // 2 strike
        final List<Integer> user6 = Arrays.asList(1, 2, 5); // 2 strike
        final List<Integer> user7 = Arrays.asList(2, 3, 5); // 2 strike

        final List<Integer> user8 = Arrays.asList(1, 3, 5); // 3 strike

        // when
        final int result1 = Player.countStrike(computer, user1, 3);
        final int result2 = Player.countStrike(computer, user2, 3);
        final int result3 = Player.countStrike(computer, user3, 3);
        final int result4 = Player.countStrike(computer, user4, 3);
        final int result5 = Player.countStrike(computer, user5, 3);
        final int result6 = Player.countStrike(computer, user6, 3);
        final int result7 = Player.countStrike(computer, user7, 3);
        final int result8 = Player.countStrike(computer, user8, 3);

        // then
        assertThat(result1).isEqualTo(0);
        assertThat(result2).isEqualTo(1);
        assertThat(result3).isEqualTo(1);
        assertThat(result4).isEqualTo(1);
        assertThat(result5).isEqualTo(2);
        assertThat(result6).isEqualTo(2);
        assertThat(result7).isEqualTo(2);
        assertThat(result8).isEqualTo(3);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
