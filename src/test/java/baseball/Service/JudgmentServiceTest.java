package baseball.Service;

import baseball.DTO.Computer;
import baseball.DTO.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class JudgmentServiceTest {
    User user;
    Computer computer = new Computer();
    JudgmentService judgmentService;
    @BeforeEach
    void 입력(){
        user = new User("123");
        computer.getComputerNumbers().set(0,1);
        computer.getComputerNumbers().set(1,2);
        computer.getComputerNumbers().set(2,4);
        judgmentService = new JudgmentService(user,computer);
        System.out.println(computer.getComputerNumbers().toString());
    }
    @Test
    void 스트라이크_판정(){
        Integer strike = judgmentService.judgeStrike();

        assertThat(strike).isEqualTo(2);
    }
    @Test
    void 볼_판정(){
        Integer ball = judgmentService.judgeBall();

        assertThat(ball).isEqualTo(0);
    }

}