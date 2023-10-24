package baseball;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class BallTest {

    @Test
    void createBall() {
        String input = "123";
        List<Integer> integerList = GameUtil.inputParse(input);

        Ball b1 = new Ball(integerList.get(0), 1);
        Ball b2 = new Ball(integerList.get(1), 2);
        Ball b3 = new Ball(integerList.get(2), 3);
    }

    @Test
    void compareBall() {
        //given
        Ball b1 = new Ball(1, 1);
        Ball b2 = new Ball(1, 2);
        Ball b3 = new Ball(3, 2);
        Ball b4 = new Ball(3, 2);

        //then
        assertThat(b1.compare(b2)).isEqualTo(BallStatus.BALL);
        assertThat(b1.compare(b3)).isEqualTo(BallStatus.NOTHING);
        assertThat(b3.compare(b4)).isEqualTo(BallStatus.STRIKE);
    }
}