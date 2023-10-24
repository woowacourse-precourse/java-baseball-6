package baseball.service.hint;

import baseball.domain.NumberBaseball;
import baseball.domain.hint.Ball;
import baseball.domain.hint.HintItem;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BallServiceImplTest {

    private final BallServiceImpl ballServiceImpl = BallServiceImpl.getInstance();

    @Test
    void create() {
        NumberBaseball computerBaseball = NumberBaseball.createBaseball("123");
        NumberBaseball inputBaseball = NumberBaseball.createBaseball("456");

        HintItem ballHint = ballServiceImpl.create(computerBaseball, inputBaseball);

        assertTrue(ballHint instanceof Ball);
    }


    @Test
    void count_zeroBall() {
        //given
        NumberBaseball computerBaseball = NumberBaseball.createBaseball("123");
        NumberBaseball inputBaseball = NumberBaseball.createBaseball("456");

        //when
        int count = ballServiceImpl.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isZero();
    }

    @Test
    void count_zeroBall_samePlace() {
        //given
        NumberBaseball computerBaseball = NumberBaseball.createBaseball("123");
        NumberBaseball inputBaseball = NumberBaseball.createBaseball("156");

        //when
        int count = ballServiceImpl.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isZero();
    }

    @Test
    void count_oneBall() {
        //given
        NumberBaseball computerBaseball = NumberBaseball.createBaseball("123");
        NumberBaseball inputBaseball = NumberBaseball.createBaseball("451");

        //when
        int count = ballServiceImpl.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isOne();
    }
}
