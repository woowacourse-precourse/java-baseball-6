package baseball.service.hint;

import baseball.domain.Baseball;
import baseball.service.hint.BallService;
import baseball.util.IntegerListUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallServiceTest {

    private final BallService ballService = BallService.getInstance();
    private Baseball computerBaseball;
    private Baseball inputBaseball;

    @BeforeEach
    void setup() {
        computerBaseball = new Baseball();
        inputBaseball = new Baseball();
    }

    @Test
    void count_zeroBall() {
        //given
        computerBaseball.setValues(IntegerListUtil.parseIntegerList("123"));
        inputBaseball.setValues(IntegerListUtil.parseIntegerList("456"));

        //when
        int count = ballService.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isZero();
    }

    @Test
    void count_zeroBall_samePlace() {
        //given
        computerBaseball.setValues(IntegerListUtil.parseIntegerList("123"));
        inputBaseball.setValues(IntegerListUtil.parseIntegerList("156"));

        //when
        int count = ballService.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isZero();
    }

    @Test
    void count_oneBall() {
        //given
        computerBaseball.setValues(IntegerListUtil.parseIntegerList("123"));
        inputBaseball.setValues(IntegerListUtil.parseIntegerList("256"));

        //when
        int count = ballService.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isOne();
    }
}
