package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
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

    @DisplayName("사용자 입력을 숫자 리스트로 변환하는 메서드 테스트")
    @Test
    void stringArrToIntegerListTest() {
        // given
        final String input1 = "123";
        final String input2 = "654";
        final String input3 = "369";

        // when
        final List<Integer> result1 = Player.stringArrToIntegerList(input1);
        final List<Integer> result2 = Player.stringArrToIntegerList(input2);
        final List<Integer> result3 = Player.stringArrToIntegerList(input3);

        // then
        assertThat(result1).isEqualTo(Arrays.asList(1, 2, 3));
        assertThat(result2).isEqualTo(Arrays.asList(6, 5, 4));
        assertThat(result3).isEqualTo(Arrays.asList(3, 6, 9));
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

    @DisplayName("볼 개수 세는 테스트")
    @Test
    void countBallTest() {
        // given
        final int size = 3;
        final List<Integer> computer = Arrays.asList(1, 3, 5);

        final List<Integer> user1 = Arrays.asList(2, 4, 8); // 0 ball

        final List<Integer> user2 = Arrays.asList(9, 8, 1); // 1 ball
        final List<Integer> user3 = Arrays.asList(9, 1, 8); // 1 ball
        final List<Integer> user4 = Arrays.asList(7, 5, 8); // 1 ball

        final List<Integer> user5 = Arrays.asList(3, 5, 9); // 2 ball
        final List<Integer> user6 = Arrays.asList(9, 1, 3); // 2 ball
        final List<Integer> user7 = Arrays.asList(5, 9, 1); // 2 ball

        final List<Integer> user8 = Arrays.asList(3, 5, 1); // 3 ball

        // when
        final int result1 = Player.countBall(computer, user1, 3);
        final int result2 = Player.countBall(computer, user2, 3);
        final int result3 = Player.countBall(computer, user3, 3);
        final int result4 = Player.countBall(computer, user4, 3);
        final int result5 = Player.countBall(computer, user5, 3);
        final int result6 = Player.countBall(computer, user6, 3);
        final int result7 = Player.countBall(computer, user7, 3);
        final int result8 = Player.countBall(computer, user8, 3);

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

    @DisplayName("결과 출력 메서드 테스트")
    @Test
    void printResultTest() {
        // given
        final List<Integer> strikeBallCnt1 = List.of(0, 0); // 낫싱
        final List<Integer> strikeBallCnt2 = List.of(0, 1); // 1볼
        final List<Integer> strikeBallCnt3 = List.of(0, 2); // 2볼
        final List<Integer> strikeBallCnt4 = List.of(1, 0); // 1스트라이크
        final List<Integer> strikeBallCnt5 = List.of(2, 0); // 2스트라이크
        final List<Integer> strikeBallCnt6 = List.of(3, 0); // 3스트라이크
        final List<Integer> strikeBallCnt7 = List.of(1, 2); // 2볼 1스트라이크

        // when
        final OutputStream result1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result1));
        Player.printResult(strikeBallCnt1.get(0), strikeBallCnt1.get(1));

        final OutputStream result2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result2));
        Player.printResult(strikeBallCnt2.get(0), strikeBallCnt2.get(1));

        final OutputStream result3 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result3));
        Player.printResult(strikeBallCnt3.get(0), strikeBallCnt3.get(1));

        final OutputStream result4 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result4));
        Player.printResult(strikeBallCnt4.get(0), strikeBallCnt4.get(1));

        final OutputStream result5 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result5));
        Player.printResult(strikeBallCnt5.get(0), strikeBallCnt5.get(1));

        final OutputStream result6 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result6));
        Player.printResult(strikeBallCnt6.get(0), strikeBallCnt6.get(1));

        final OutputStream result7 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result7));
        Player.printResult(strikeBallCnt7.get(0), strikeBallCnt7.get(1));

        // then
        assertThat(result1.toString().strip()).isEqualTo("낫싱");
        assertThat(result2.toString().strip()).isEqualTo("1볼");
        assertThat(result3.toString().strip()).isEqualTo("2볼");
        assertThat(result4.toString().strip()).isEqualTo("1스트라이크");
        assertThat(result5.toString().strip()).isEqualTo("2스트라이크");
        assertThat(result6.toString().strip()).isEqualTo("3스트라이크");
        assertThat(result7.toString().strip()).isEqualTo("2볼 1스트라이크");
    }

    @DisplayName("게임 재시작/종료 입력 유효성 확인 메서드 예외처리 테스트")
    @Test
    public void isOneOrTwoExceptionTest() {
        // given
        final String input1 = "0";
        final String input2 = "3";
        final String input3 = "yes";
        final String input4 = "no";
        final String input5 = "!";

        // when
        final Throwable throwable1 = catchThrowable(() -> {
            Player.isOneOrTwo(input1);
        });
        final Throwable throwable2 = catchThrowable(() -> {
            Player.isOneOrTwo(input2);
        });
        final Throwable throwable3 = catchThrowable(() -> {
            Player.isOneOrTwo(input3);
        });
        final Throwable throwable4 = catchThrowable(() -> {
            Player.isOneOrTwo(input4);
        });
        final Throwable throwable5 = catchThrowable(() -> {
            Player.isOneOrTwo(input5);
        });

        // then
        assertThat(throwable1)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 또는 2만 입력해야합니다.");
        assertThat(throwable2)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 또는 2만 입력해야합니다.");
        assertThat(throwable3)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 또는 2만 입력해야합니다.");
        assertThat(throwable4)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 또는 2만 입력해야합니다.");
        assertThat(throwable5)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 또는 2만 입력해야합니다.");
    }

    @DisplayName("게임 재시작/종료 입력 유효성 확인 메서드 정상처리 테스트")
    @Test
    public void isOneOrTwoTest() {
        // given
        final String input1 = "1";
        final String input2 = "2";

        // when
        final Throwable throwable1 = catchThrowable(() -> {
            Player.isOneOrTwo(input1);
        });
        final Throwable throwable2 = catchThrowable(() -> {
            Player.isOneOrTwo(input2);
        });

        // then
        assertThat(throwable1).doesNotThrowAnyException();
        assertThat(throwable2).doesNotThrowAnyException();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
