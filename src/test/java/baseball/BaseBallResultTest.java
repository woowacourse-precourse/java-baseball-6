package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseBallResultTest {
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    void setUp() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    String output() {
        return captor.toString().trim();
    }

    @Test
    void 다른_위치에_숫자가_같으면_볼() {
        BaseBallResult baseBallResult = new BaseBallResult(
                new BaseBallNumberGroup(List.of(1, 2, 3)),
                new BaseBallNumberGroup(List.of(4, 5, 1))
        );

        baseBallResult.print();
        assertThat(output()).contains("1볼");
    }

    @Test
    void 같은_위치에_숫자가_같으면_스트라이크() {
        BaseBallResult baseBallResult = new BaseBallResult(
                new BaseBallNumberGroup(List.of(1, 2, 3)),
                new BaseBallNumberGroup(List.of(1, 4, 5))
        );

        baseBallResult.print();
        assertThat(output()).contains("1스트라이크");
    }

    @Test
    void 볼과_스트라이크_출력시_볼이_먼저_출력() {
        BaseBallResult baseBallResult = new BaseBallResult(
                new BaseBallNumberGroup(List.of(1, 2, 3)),
                new BaseBallNumberGroup(List.of(1, 4, 2))
        );

        baseBallResult.print();
        assertThat(output()).contains("1볼 1스트라이크");
    }

    @Test
    void 볼과_스트라이크가_없을시_낫싱_출력() {
        BaseBallResult baseBallResult = new BaseBallResult(
                new BaseBallNumberGroup(List.of(1, 2, 3)),
                new BaseBallNumberGroup(List.of(4, 5, 6))
        );

        baseBallResult.print();
        assertThat(output()).contains("낫싱");
    }

    @Test
    void 모두_스트라이크_일때_isAllStrike_true_반환() {
        BaseBallResult baseBallResult = new BaseBallResult(
                new BaseBallNumberGroup(List.of(1, 2, 3)),
                new BaseBallNumberGroup(List.of(1, 2, 3))
        );

        boolean isAllStrike = baseBallResult.isAllStrike();
        assertThat(isAllStrike).isTrue();
    }

    @Test
    void 모두_스트라이크가_아닐때_isAllStrike_false_반환() {
        BaseBallResult baseBallResult = new BaseBallResult(
                new BaseBallNumberGroup(List.of(1, 2, 3)),
                new BaseBallNumberGroup(List.of(1, 2, 4))
        );

        boolean isAllStrike = baseBallResult.isAllStrike();
        assertThat(isAllStrike).isFalse();
    }
}
