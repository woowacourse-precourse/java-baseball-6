package baseball;

import balls.Balls;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BaseballGameServiceTest {
    BaseballGameService baseballGameService = new BaseballGameService();

    @Test
    public void 컴퓨터와_유저가_입력한_값이_일치하는_경우_테스트() {
        //given
        Balls computerBalls = new Balls(Arrays.asList(8, 6, 9));
        Balls userBalls = new Balls(Arrays.asList(8, 6, 9));
        //when
        boolean run = baseballGameService.baseballGameServiceStart(computerBalls, userBalls);
        //then
        Assertions.assertFalse(run);
    }

    @Test
    public void 컴퓨터와_유저가_입력한_값이_일치하지_않은_경우_테스트() {
        //given
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        Balls userBalls = new Balls(Arrays.asList(8, 6, 9));
        //when
        boolean run = baseballGameService.baseballGameServiceStart(computerBalls, userBalls);
        //then
        Assertions.assertTrue(run);
    }
}

