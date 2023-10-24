package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class myTest extends NsTest {
    @Test
    void 게임시작_출력_테스트() {
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        OutputView.printStartGameMessage();
        assertThat(outContent.toString()).contains("숫자 야구 게임을 시작합니다.");
        System.setOut(standardOut);
    }

    @Test
    void 힌트_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("789", "235", "145", "321", "123", "2");
                    assertThat(output()).contains("낫싱", "2볼", "1스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 2, 3
        );
    }

    @Test
    void 게임종료_출력_테스트() {
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        OutputView.printSuccessAndEndGameMessage();
        assertThat(outContent.toString()).contains("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.setOut(standardOut);
    }

    @Test
    void 게임_재시작_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("468", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 중복숫자_예외_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> {
                        run("123", "999");
                        // runMain();
                    }).isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("중복된 원소가 있습니다.");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void anything() {
        // String
        assertThat("Hello")
                .isNotEmpty()
                .contains("ello")
                .doesNotContain("alo")
                .startsWith("Hell")
                .endsWith("ello")
                .isEqualTo("Hello");

        assertEquals(2, 2);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
