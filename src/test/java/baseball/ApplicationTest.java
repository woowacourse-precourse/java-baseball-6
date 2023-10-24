package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;

import baseball.controller.Core;
import baseball.controller.Generator;
import baseball.controller.Validation;
import baseball.model.Result;
import baseball.view.View;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    void showResult() {
        // given
        Result case1 = new Result(0, 0);
        Result case2 = new Result(0, 2);
        Result case3 = new Result(2, 0);
        Result case4 = new Result(1, 1);

        // when
        OutputStream result1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result1));
        View.showResult(case1);

        OutputStream result2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result2));
        View.showResult(case2);

        OutputStream result3 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result3));
        View.showResult(case3);

        OutputStream result4 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result4));
        View.showResult(case4);

        // then
        assertThat(result1.toString().strip()).as("0 strike 0 ball").isEqualTo("낫싱");
        assertThat(result2.toString().strip()).as("0 strike 2 ball").isEqualTo("2볼");
        assertThat(result3.toString().strip()).as("2 strike 0 ball").isEqualTo("2스트라이크");
        assertThat(result4.toString().strip()).as("1 strike 1 ball").isEqualTo("1볼 1스트라이크");

    }

    @Test
    void validateDuplication() {
        // given
        String case1 = "123";
        String case2 = "112";
        String case3 = "a23";
        String case4 = "a2a";

        // when
        Throwable result1 = catchThrowable(() -> {
            Validation.validateDuplication(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            Validation.validateDuplication(case2);
        });
        Throwable result3 = catchThrowable(() -> {
            Validation.validateDuplication(case3);
        });
        Throwable result4 = catchThrowable(() -> {
            Validation.validateDuplication(case4);
        });

        // then
        assertThat(result1).as("valid list").doesNotThrowAnyException();
        assertThat(result2).as("invalid with duplication").isInstanceOf(IllegalArgumentException.class);
        assertThat(result3).as("valid list").doesNotThrowAnyException();
        assertThat(result4).as("invalid with duplication").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNumber() {
        // given
        String case1 = "123";
        String case2 = "012";
        String case3 = "abc";
        String case4 = "-112";

        // when
        Throwable result1 = catchThrowable(() -> {
            Validation.validateNumber(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            Validation.validateNumber(case2);
        });
        Throwable result3 = catchThrowable(() -> {
            Validation.validateNumber(case3);
        });
        Throwable result4 = catchThrowable(() -> {
            Validation.validateNumber(case4);
        });

        // then
        assertThat(result1).as("valid list").doesNotThrowAnyException();
        assertThat(result2).as("invalid with 0").isInstanceOf(IllegalArgumentException.class);
        assertThat(result3).as("invalid with NaN").isInstanceOf(IllegalArgumentException.class);
        assertThat(result4).as("invalid with NaN").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateOneOrTwo() {
        // given
        String case1 = "1";
        String case2 = "2";
        String case3 = "3";
        String case4 = "a";

        // when
        Throwable result1 = catchThrowable(() -> {
            Validation.validateOneOrTwo(case1, 1);
        });
        Throwable result2 = catchThrowable(() -> {
            Validation.validateOneOrTwo(case2, 1);
        });
        Throwable result3 = catchThrowable(() -> {
            Validation.validateOneOrTwo(case3, 1);
        });
        Throwable result4 = catchThrowable(() -> {
            Validation.validateOneOrTwo(case4, 1);
        });

        // then
        assertThat(result1).as("input: 1").doesNotThrowAnyException();
        assertThat(result2).as("input: 2").doesNotThrowAnyException();
        assertThat(result3).as("invalid input").isInstanceOf(IllegalArgumentException.class);
        assertThat(result4).as("invalid input").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateInputLength() {
        // given
        String case1 = "123";
        String case2 = "12";
        String case3 = "1234";

        // when
        Throwable result1 = catchThrowable(() -> {
            Validation.validateInputLength(case1, 3);
        });
        Throwable result2 = catchThrowable(() -> {
            Validation.validateInputLength(case2, 3);
        });
        Throwable result3 = catchThrowable(() -> {
            Validation.validateInputLength(case3, 3);
        });

        // then
        assertThat(result1).as("valid input").doesNotThrowAnyException();
        assertThat(result2).as("invalid input1").isInstanceOf(IllegalArgumentException.class);
        assertThat(result3).as("invalid input2").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generateNumericInputList() {
        // given
        String case1 = "123";
        String case2 = "1234";

        // when
        List<Integer> result1 = Generator.generateNumericInputList(case1);
        List<Integer> result2 = Generator.generateNumericInputList(case2);

        // then
        assertThat(result1).as("case1").isEqualTo(List.of(1, 2, 3));
        assertThat(result2).as("case2").isEqualTo(List.of(1, 2, 3, 4));
    }

    @Test
    void generateAnswer() {
        // given
        int listLen = 3;

        // when
        List<Integer> result = Generator.generateAnswer(listLen);

        // then
        assertThat(result.size()).as("list size").isEqualTo(listLen);

        List<Integer> check = new ArrayList<>();
        for (int num : result) {
            assertThat(false).as("duplication").isEqualTo(check.contains(num));
            check.add(num);
        }
    }

    @Test
    void isNotOver() {
        // given
        int case1 = 0;
        int case2 = 1;
        int case3 = 2;
        int case4 = 3;

        // when
        boolean result1 = Core.isNotOver(case1);
        boolean result2 = Core.isNotOver(case2);
        boolean result3 = Core.isNotOver(case3);
        boolean result4 = Core.isNotOver(case4);

        // then
        assertThat(result1).as("nothing").isEqualTo(true);
        assertThat(result3).as("1 strike").isEqualTo(true);
        assertThat(result2).as("2 strike").isEqualTo(true);
        assertThat(result4).as("3 strike").isEqualTo(false);
    }

    @Test
    void countBall() {
        // given
        List<List<Integer>> case1 = List.of(List.of(1, 2, 3), List.of(4, 5, 6)); // nothing
        List<List<Integer>> case2 = List.of(List.of(1, 2, 3), List.of(4, 1, 6)); // 1 ball
        List<List<Integer>> case3 = List.of(List.of(1, 2, 3), List.of(4, 1, 2)); // 2 ball
        List<List<Integer>> case4 = List.of(List.of(1, 2, 3), List.of(3, 1, 2)); // 3 ball
        List<List<Integer>> case5 = List.of(List.of(1, 2, 3), List.of(1, 5, 6)); // 1 strike
        List<List<Integer>> case6 = List.of(List.of(1, 2, 3), List.of(1, 3, 6)); // 1 strike 1 ball
        List<List<Integer>> case7 = List.of(List.of(1, 2, 3), List.of(1, 3, 2)); // 1 strike 2 ball
        List<List<Integer>> case8 = List.of(List.of(1, 2, 3), List.of(1, 2, 6)); // 2 strike
        List<List<Integer>> case9 = List.of(List.of(1, 2, 3), List.of(1, 2, 3)); // 3 strike

        // when
        int result1 = Core.countBall(case1.get(0), case1.get(1));
        int result2 = Core.countBall(case2.get(0), case2.get(1));
        int result3 = Core.countBall(case3.get(0), case3.get(1));
        int result4 = Core.countBall(case4.get(0), case4.get(1));
        int result5 = Core.countBall(case5.get(0), case5.get(1));
        int result6 = Core.countBall(case6.get(0), case6.get(1));
        int result7 = Core.countBall(case7.get(0), case7.get(1));
        int result8 = Core.countBall(case8.get(0), case8.get(1));
        int result9 = Core.countBall(case9.get(0), case9.get(1));

        // then
        assertThat(result1).as("nothing").isEqualTo(0);
        assertThat(result2).as("1 ball").isEqualTo(1);
        assertThat(result3).as("2 ball").isEqualTo(2);
        assertThat(result4).as("3 ball").isEqualTo(3);
        assertThat(result5).as("1 strike").isEqualTo(0);
        assertThat(result6).as("1 strike 2 ball").isEqualTo(1);
        assertThat(result7).as("1 strike 2 ball").isEqualTo(2);
        assertThat(result8).as("2 strike").isEqualTo(0);
        assertThat(result9).as("3 strike").isEqualTo(0);
    }


    @Test
    void countStrike() {
        // given
        List<List<Integer>> case1 = List.of(List.of(1, 2, 3), List.of(4, 5, 6)); // nothing
        List<List<Integer>> case2 = List.of(List.of(1, 2, 3), List.of(4, 1, 6)); // 1 ball
        List<List<Integer>> case3 = List.of(List.of(1, 2, 3), List.of(4, 1, 2)); // 2 ball
        List<List<Integer>> case4 = List.of(List.of(1, 2, 3), List.of(3, 1, 2)); // 3 ball
        List<List<Integer>> case5 = List.of(List.of(1, 2, 3), List.of(1, 5, 6)); // 1 strike
        List<List<Integer>> case6 = List.of(List.of(1, 2, 3), List.of(1, 3, 6)); // 1 strike 1 ball
        List<List<Integer>> case7 = List.of(List.of(1, 2, 3), List.of(1, 3, 2)); // 1 strike 2 ball
        List<List<Integer>> case8 = List.of(List.of(1, 2, 3), List.of(1, 2, 6)); // 2 strike
        List<List<Integer>> case9 = List.of(List.of(1, 2, 3), List.of(1, 2, 3)); // 3 strike

        // when
        int result1 = Core.countStrike(case1.get(0), case1.get(1));
        int result2 = Core.countStrike(case2.get(0), case2.get(1));
        int result3 = Core.countStrike(case3.get(0), case3.get(1));
        int result4 = Core.countStrike(case4.get(0), case4.get(1));
        int result5 = Core.countStrike(case5.get(0), case5.get(1));
        int result6 = Core.countStrike(case6.get(0), case6.get(1));
        int result7 = Core.countStrike(case7.get(0), case7.get(1));
        int result8 = Core.countStrike(case8.get(0), case8.get(1));
        int result9 = Core.countStrike(case9.get(0), case9.get(1));

        // then
        assertThat(result1).as("nothing").isEqualTo(0);
        assertThat(result2).as("1 ball").isEqualTo(0);
        assertThat(result3).as("2 ball").isEqualTo(0);
        assertThat(result4).as("3 ball").isEqualTo(0);
        assertThat(result5).as("1 strike").isEqualTo(1);
        assertThat(result6).as("1 strike 2 ball").isEqualTo(1);
        assertThat(result7).as("1 strike 2 ball").isEqualTo(1);
        assertThat(result8).as("2 strike").isEqualTo(2);
        assertThat(result9).as("3 strike").isEqualTo(3);
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
}
