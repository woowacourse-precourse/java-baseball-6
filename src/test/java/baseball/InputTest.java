package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputTest {

    @Test
    void restart_유효한값_야구재시작(){

        //given
        String input = "2";
        //when
        Baseball baseball = new Baseball();
        baseball.restartBall(input);

        //then
        Assertions.assertThat(baseball.restartBall(input)).isEqualTo(true);


    }
}
