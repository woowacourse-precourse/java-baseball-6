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
    void 힌트_테스트(){
        //given
        //List<Integer> computerNumber=new ArrayList<Integer>(Arrays.asList(1,2,3));
        //List<Integer> userNumber=new ArrayList<Integer>(Arrays.asList(1,3,6));
        Balls computerBalls=new Balls(new ArrayList<Integer>(Arrays.asList(1,2,3)));
        Balls userBalls=new Balls(new ArrayList<Integer>(Arrays.asList(1,3,6)));
        List<Integer> expected=new ArrayList<>(Arrays.asList(1,1));

        //when
        Comparator comparator=new Comparator();
        comparator.compare(computerBalls,computerBalls);

        //then
        Assertions.assertThat(expected.containsAll(comparator.getHint())).isEqualTo(true);
    }

}