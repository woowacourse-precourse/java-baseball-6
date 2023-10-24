package baseball.service.hint;

import baseball.domain.Baseball;
import baseball.service.hint.BallService;
import baseball.util.IntegerListUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallServiceTest {

    private final BallService ballService = BallService.getInstance();


    @Test
    void count_zeroBall() {
        //given
        Baseball computerBaseball = Baseball.createBaseball("123");
        Baseball inputBaseball = Baseball.createBaseball("456");

        //when
        int count = ballService.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isZero();
    }

    @Test
    void count_zeroBall_samePlace() {
        //given
        Baseball computerBaseball = Baseball.createBaseball("123");
        Baseball inputBaseball = Baseball.createBaseball("156");

        //when
        int count = ballService.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isZero();
    }

    @Test
    void count_oneBall() {
        //given
        Baseball computerBaseball = Baseball.createBaseball("123");
        Baseball inputBaseball = Baseball.createBaseball("256");

        //when
        int count = ballService.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isOne();
    }
}
