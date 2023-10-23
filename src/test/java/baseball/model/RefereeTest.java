package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RefereeTest {

    @Test
    @DisplayName("스트라이 검사")
    public void isStrike() throws Exception{
        //given (주어진 값)
        Referee referee = new Referee();

        //when (기능 작동)
        int strike = referee.confirmStrike(1,1);
        int isNotStrike = referee.confirmStrike(1,3);

        //then (기능 작동 후 결과)
        Assertions.assertThat(strike).isEqualTo(1);
        Assertions.assertThat(isNotStrike).isEqualTo(0);
    }

    @Test
    @DisplayName("볼 검사")
    public void isBall() throws Exception{
        //given (주어진 값)
        Referee referee = new Referee();
        List<Integer> playerList = new ArrayList<>(Arrays.asList(0, 1, 3));

        //when (기능 작동)
        int isBall = referee.confirmBall(1,0, playerList);
        int isStrike = referee.confirmBall(0,0, playerList);
        int isNotBall = referee.confirmBall(5,1,playerList);

        //then (기능 작동 후 결과)
        Assertions.assertThat(isBall).isEqualTo(1);
        Assertions.assertThat(isStrike).isEqualTo(0);
        Assertions.assertThat(isNotBall).isEqualTo(0);
    }

    @Test
    @DisplayName("스트라이크와 볼 개수 검사")
    public void test() throws Exception{
        //given (주어진 값)
        Referee referee = new Referee();
        List<Integer> computer = new ArrayList<>(Arrays.asList(1,5,7));
        List<Integer> player = new ArrayList<>(Arrays.asList(7,5,2));


        //when (기능 작동)
        referee.compareNumbers(computer,player);
        int strike = referee.getStrike();
        int ball = referee.getBall();

        //then (기능 작동 후 결과)
        Assertions.assertThat(strike).isEqualTo(1);
        Assertions.assertThat(ball).isEqualTo(1);

    }
}