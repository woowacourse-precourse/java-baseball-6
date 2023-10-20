package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.*;


class BallsTest {

    @Test
    void createBalls() {
        String input = "123";
        List<Integer> integerList = GameUtil.inputParse(input);
        Balls balls = new Balls(integerList);
    }

    @Test
    void compareBalls() {
        //given
        String input = "321";
        List<Integer> integerList1 = GameUtil.inputParse(input);

        String input2 = "123";
        List<Integer> integerList2 = GameUtil.inputParse(input2);

        Balls computer = new Balls(integerList1);
        Balls me = new Balls(integerList2);

        //when
        String compare = me.compare(computer);

        //then
        assertThat(compare).isEqualTo("2볼 1스트라이크");
    }
}