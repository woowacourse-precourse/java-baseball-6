package baseball.judgement;

import baseball.computer.judgement.JudgeResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class JudgeResultTest {
    JudgeResult judgeResult;

    @BeforeEach
    void setUp() {
        judgeResult = new JudgeResult();
    }

    @Test
    void nothing(){
        String result = judgeResult.getResult(List.of(4, 5, 6), List.of(1, 2, 3));

        assertThat(result).isEqualTo("낫싱");
    }

    @Test
    void one_ball(){
        String result = judgeResult.getResult(List.of(4, 5, 1), List.of(1, 2, 3));

        assertThat(result).isEqualTo("1볼");
    }

    @Test
    void two_ball(){
        String result = judgeResult.getResult(List.of(4, 1, 2), List.of(1, 2, 3));

        assertThat(result).isEqualTo("2볼");
    }

    @Test
    void three_ball(){
        String result = judgeResult.getResult(List.of(1, 2, 3), List.of(3, 1, 2));

        assertThat(result).isEqualTo("3볼");
    }

    @Test
    void one_strike(){
        String result = judgeResult.getResult(List.of(1, 4, 5), List.of(1, 2, 3));

        assertThat(result).isEqualTo("1스트라이크");
    }

    @Test
    void two_strike(){
        String result = judgeResult.getResult(List.of(1, 2, 5), List.of(1, 2, 3));

        assertThat(result).isEqualTo("2스트라이크");
    }

    @Test
    void three_strike(){
        String result = judgeResult.getResult(List.of(1, 2, 3), List.of(1, 2, 3));

        assertThat(result).isEqualTo("3스트라이크");
    }

    @Test
    void one_ball_one_strike(){
        String result = judgeResult.getResult(List.of(1, 4, 2), List.of(1, 2, 3));

        assertThat(result).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void two_ball_one_strike(){
        String result = judgeResult.getResult(List.of(1, 3, 2), List.of(1, 2, 3));

        assertThat(result).isEqualTo("2볼 1스트라이크");
    }
}