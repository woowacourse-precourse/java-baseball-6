package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 스트라이크3개 (){
        assertRandomNumberInRangeTest(
                () -> {
                    run("135","2");
                    assertThat(output()).contains("3스트라이크","게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 스트라이크2개(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("135","145","2");
                    assertThat(output()).contains("2스트라이크","3스트라이크","게임 종료");
                },
                1, 4, 5
        );
    }

    @Test
    void 스트라이크1개(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("136","145","2");
                    assertThat(output()).contains("1스트라이크","3스트라이크","게임 종료");
                },
                1, 4, 5
        );
    }

    @Test
    void 볼1개(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("781","145","2");
                    assertThat(output()).contains("1볼","3스트라이크","게임 종료");
                },
                1, 4, 5
        );
    }

    @Test
    void 볼2개(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("481","145","2");
                    assertThat(output()).contains("2볼","3스트라이크","게임 종료");
                },
                1, 4, 5
        );
    }

    @Test
    void 볼3개(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("514","145","2");
                    assertThat(output()).contains("3볼","3스트라이크","게임 종료");
                },
                1, 4, 5
        );
    }

    @Test
    void 볼1개스트라이크1개(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("156","145","2");
                    assertThat(output()).contains("1볼","1스트라이크","게임 종료");
                },
                1, 4, 5
        );
    }

    @Test
    void 볼2개스트라이크1개(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("154","145","2");
                    assertThat(output()).contains("2볼","1스트라이크","게임 종료");
                },
                1, 4, 5
        );
    }

    @Test
    void 낫띵(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("789","145","2");
                    assertThat(output()).contains("낫싱","게임 종료");
                },
                1, 4, 5
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트1_빈문자열_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트2_숫자1개_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }



    @Test
    void 예외_테스트3_숫자2개_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 예외_테스트3_숫자가아닌문자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aaa"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
