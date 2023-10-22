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
        View view = new View();
        Result case1 = new Result(0, 0);
        Result case2 = new Result(0, 2);
        Result case3 = new Result(2, 0);
        Result case4 = new Result(1, 1);

        // when
        OutputStream result1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result1));
        view.showResult(case1);

        OutputStream result2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result2));
        view.showResult(case2);

        OutputStream result3 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result3));
        view.showResult(case3);

        OutputStream result4 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result4));
        view.showResult(case4);

        // then
        assertThat(result1.toString().strip()).as("0 strike 0 ball").isEqualTo("낫싱");
        assertThat(result2.toString().strip()).as("0 strike 2 ball").isEqualTo("2볼");
        assertThat(result3.toString().strip()).as("2 strike 0 ball").isEqualTo("2스트라이크");
        assertThat(result4.toString().strip()).as("1 strike 1 ball").isEqualTo("1볼 1스트라이크");

    }

    @Test
    void validateDuplication() {
        // given
        Validation validation = new Validation();
        List<String> case1 = List.of("1", "2", "3");
        List<String> case2 = List.of("1", "1", "2");

        // when
        Throwable result1 = catchThrowable(() -> {
            validation.validateDuplication(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            validation.validateDuplication(case2);
        });

        // then
        assertThat(result1).as("valid list").doesNotThrowAnyException();
        assertThat(result2).as("invalid with duplication").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNumber() {
        // given
        Validation validation = new Validation();
        List<String> case1 = List.of("1", "2", "3");
        List<String> case2 = List.of("0", "1", "2");
        List<String> case3 = List.of("-1", "1", "2");

        // when
        Throwable result1 = catchThrowable(() -> {
            validation.validateNumber(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            validation.validateNumber(case2);
        });
        Throwable result3 = catchThrowable(() -> {
            validation.validateNumber(case3);
        });

        // then
        assertThat(result1).as("valid list").doesNotThrowAnyException();
        assertThat(result2).as("invalid with 0").isInstanceOf(IllegalArgumentException.class);
        assertThat(result3).as("invalid with -1").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateOneOrTwo() {
        // given
        Validation validation = new Validation();
        int case1 = 1;
        int case2 = 2;
        int case3 = 5;

        // when
        Throwable result1 = catchThrowable(() -> {
            validation.validateOneOrTwo(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            validation.validateOneOrTwo(case2);
        });
        Throwable result3 = catchThrowable(() -> {
            validation.validateOneOrTwo(case3);
        });

        // then
        assertThat(result1).as("input: 1").doesNotThrowAnyException();
        assertThat(result2).as("input: 2").doesNotThrowAnyException();
        assertThat(result3).as("invalid input").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateInputLength() {
        // given
        Validation validation = new Validation();
        String case1 = "123";
        String case2 = "12";
        String case3 = "1234";

        // when
        Throwable result1 = catchThrowable(() -> {
            validation.validateInputLength(case1, 3);
        });
        Throwable result2 = catchThrowable(() -> {
            validation.validateInputLength(case2, 3);
        });
        Throwable result3 = catchThrowable(() -> {
            validation.validateInputLength(case3, 3);
        });

        // then
        assertThat(result1).as("valid input").doesNotThrowAnyException();
        assertThat(result2).as("invalid input1").isInstanceOf(IllegalArgumentException.class);
        assertThat(result3).as("invalid input2").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generateInputList() {
        // given
        Generator generator = new Generator();
        String case1 = "123";

        // when
        List<Integer> result1 = generator.generateInputList(case1);

        // then
        assertThat(result1.size()).as("list size").isEqualTo(case1.length());
    }

    @Test
    void generateAnswer() {
        // given
        Generator generator = new Generator();
        int listLen = 3;

        // when
        List<Integer> result = generator.generateAnswer(listLen);

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
        Core core = new Core();
        int case1 = 0;
        int case2 = 1;
        int case3 = 2;
        int case4 = 3;

        // when
        boolean result1 = core.isNotOver(case1);
        boolean result2 = core.isNotOver(case2);
        boolean result3 = core.isNotOver(case3);
        boolean result4 = core.isNotOver(case4);

        // then
        assertThat(result1).as("nothing").isEqualTo(true);
        assertThat(result3).as("1 strike").isEqualTo(true);
        assertThat(result2).as("2 strike").isEqualTo(true);
        assertThat(result4).as("3 strike").isEqualTo(false);
    }

    @Test
    void countBall() {
        // given
        Core core = new Core();
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
        int result1 = core.countBall(case1.get(0), case1.get(1));
        int result2 = core.countBall(case2.get(0), case2.get(1));
        int result3 = core.countBall(case3.get(0), case3.get(1));
        int result4 = core.countBall(case4.get(0), case4.get(1));
        int result5 = core.countBall(case5.get(0), case5.get(1));
        int result6 = core.countBall(case6.get(0), case6.get(1));
        int result7 = core.countBall(case7.get(0), case7.get(1));
        int result8 = core.countBall(case8.get(0), case8.get(1));
        int result9 = core.countBall(case9.get(0), case9.get(1));

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
        Core core = new Core();
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
        int result1 = core.countStrike(case1.get(0), case1.get(1));
        int result2 = core.countStrike(case2.get(0), case2.get(1));
        int result3 = core.countStrike(case3.get(0), case3.get(1));
        int result4 = core.countStrike(case4.get(0), case4.get(1));
        int result5 = core.countStrike(case5.get(0), case5.get(1));
        int result6 = core.countStrike(case6.get(0), case6.get(1));
        int result7 = core.countStrike(case7.get(0), case7.get(1));
        int result8 = core.countStrike(case8.get(0), case8.get(1));
        int result9 = core.countStrike(case9.get(0), case9.get(1));

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
