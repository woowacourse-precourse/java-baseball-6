package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


public class JudgmentTest {

    List<Integer> tempAnswer = List.of(1, 2, 3);

    Judgment judgment = new Judgment(tempAnswer);

    @AfterEach
    void closeScanner() {
        Console.close();
    }

    @Test
    void 추측값이_정답이라면_judge_결과로_true를_반환한다() {
        // given
        List<Integer> guess = tempAnswer;
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // when
        boolean result = judgment.judge(guess);

        //then
        assertThat(out.toString()).contains("3스트라이크");
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 추측값이_정답이_아니고_볼과_스트라이크가_모두_없는_경우() {
        // given
        List<Integer> guess = List.of(4, 5, 6);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // when
        boolean result = judgment.judge(guess);

        //then
        assertThat(out.toString()).contains("낫싱");
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 볼과_스트라이크가_모두_존재하는_경우() {
        // given
        List<Integer> guess = List.of(2, 5, 3);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // when
        boolean result = judgment.judge(guess);

        //then
        assertThat(out.toString()).contains("1볼 1스트라이크");
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 볼만_존재하는_경우() {
        // given
        List<Integer> guess = List.of(2, 9, 1);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // when
        boolean result = judgment.judge(guess);

        //then
        assertThat(out.toString()).contains("2볼");
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 스트라이크만_존재하는_경우() {
        // given
        List<Integer> guess = List.of(1, 2, 7);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // when
        boolean result = judgment.judge(guess);

        //then
        assertThat(out.toString()).contains("2스트라이크");
        assertThat(result).isEqualTo(false);
    }

}