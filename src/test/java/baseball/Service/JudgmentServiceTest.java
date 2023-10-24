package baseball.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class JudgmentServiceTest {
    List<Integer> userNumbers = new ArrayList<>();
    List<Integer> computerNumbers = new ArrayList<>();
    @BeforeEach
    void 입력(){
        userNumbers.add(8);
        userNumbers.add(7);
        userNumbers.add(6);
        computerNumbers.add(1);
        computerNumbers.add(2);
        computerNumbers.add(3);
    }
    @Test
    void 스트라이크_판정(){
        JudgmentService judgmentService = new JudgmentService();
        Integer strike = judgmentService.countStrike(userNumbers,computerNumbers);

        assertThat(strike).isEqualTo(0);
    }
    @Test
    void 볼_판정(){
        JudgmentService judgmentService = new JudgmentService();
        Integer ball = judgmentService.judgeBall(userNumbers,computerNumbers);

        assertThat(ball).isEqualTo(0);
    }
    @Test
    void 낫싱_판정(){
        JudgmentService judgmentService = new JudgmentService();
        Integer strike = judgmentService.countStrike(userNumbers,computerNumbers);
        Integer ball = judgmentService.judgeBall(userNumbers,computerNumbers);

        assertThat(ball+strike).isEqualTo(0);
    }
}