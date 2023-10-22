package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class JudgeResultTest {
    @Test
    void 스트라이크_개수_판단_잘하는지_확인() {
        List<Integer> computer = Arrays.asList(5, 2, 3);
        List<Integer> player = Arrays.asList(1, 2, 3);
        JudgeResult judge = new JudgeResult(computer, player);
        System.out.println(judge.getResult());
        assertThat(judge.getResult().equals("2스트라이크"));
    }

    @Test
    void 볼_개수_판단_잘하는지_확인() {
        List<Integer> computer = Arrays.asList(3, 1, 5);
        List<Integer> player = Arrays.asList(1, 2, 3);
        JudgeResult judge = new JudgeResult(computer, player);
        System.out.println(judge.getResult());
        assertThat(judge.getResult().equals("2볼"));
    }

    @Test
    void 볼과_스트라이크_개수_판단_잘하는지_확인() {
        List<Integer> computer = Arrays.asList(1, 3, 2);
        List<Integer> player = Arrays.asList(1, 2, 3);
        JudgeResult judge = new JudgeResult(computer, player);
        System.out.println(judge.getResult());
        assertThat(judge.getResult().equals("2볼 1스트라이크"));
    }

    @Test
    void 낫싱_판단_잘하는지_확인() {
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> player = Arrays.asList(4, 5, 6);
        JudgeResult judge = new JudgeResult(computer, player);
        System.out.println(judge.getResult());
        assertThat(judge.getResult().equals("낫싱"));
    }
}
