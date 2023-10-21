package computer;

import baseball.Balls;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComparatorTest {

    @Test
    @DisplayName("컴퓨터의 숫자와 사용자 숫자 비교")
    void 힌트_테스트o(){
        //given
        Balls computerBalls=new Balls(new ArrayList<Integer>(Arrays.asList(1,2,4)));
        Balls userBalls=new Balls(new ArrayList<Integer>(Arrays.asList(1,4,2)));
        int strike=1;
        int ball=2;
        Hint hint=new Hint();

        //when
        Comparator comparator=new Comparator();
        comparator.compare(computerBalls,userBalls);


        //then
        Assertions.assertThat(comparator.strike).isEqualTo(1);
        Assertions.assertThat(comparator.ball).isEqualTo(2);
    }



}