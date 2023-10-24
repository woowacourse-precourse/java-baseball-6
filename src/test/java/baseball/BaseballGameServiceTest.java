package baseball;

import balls.Balls;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameServiceTest {
    BaseballGameService baseballGameService= new BaseballGameService();
    @Test
    public void 볼_개수_세는_테스트(){
        //given
        List<Integer> computer = new ArrayList<>();
        computer.add(1);
        computer.add(2);
        computer.add(3);
        Balls computerBalls = new Balls(computer);
        List<Integer> user = new ArrayList<>();
        user.add(3);
        user.add(1);
        user.add(2);
        Balls userBalls = new Balls(user);
        //when
        int ball= baseballGameService.countBall(computerBalls,userBalls);
        //then
        Assertions.assertEquals(3,ball);
    }
    @Test
    public void 스트라이크_개수_세는_테스트(){
        //given
        List<Integer> computer = new ArrayList<>();
        computer.add(8);
        computer.add(6);
        computer.add(9);
        Balls computerBalls = new Balls(computer);
        List<Integer> user = new ArrayList<>();
        user.add(7);
        user.add(6);
        user.add(9);
        Balls userBalls = new Balls(user);
        //when
        int strike= baseballGameService.countStrike(computerBalls,userBalls);
        //then
        Assertions.assertEquals(2,strike);
    }
}
