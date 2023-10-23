package baseball.service.hint;

import baseball.domain.Baseball;
import baseball.service.hint.StrikeService;
import baseball.util.IntegerListUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StrikeServiceTest {

    private final StrikeService strikeService = StrikeService.getInstance();
    private Baseball computerBaseball;
    private Baseball inputBaseball;

    @BeforeEach
    void setup() {
        computerBaseball = new Baseball();
        inputBaseball = new Baseball();
    }

    @Test
    void count_zeroStrike() {
        //given
        computerBaseball.setValues(IntegerListUtil.parseIntegerList("123"));
        inputBaseball.setValues(IntegerListUtil.parseIntegerList("456"));

        //when
        int count = strikeService.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isZero();
    }

    @Test
    void count_zeroStrike_differentPlace() {
        //given
        computerBaseball.setValues(IntegerListUtil.parseIntegerList("123"));
        inputBaseball.setValues(IntegerListUtil.parseIntegerList("451"));

        //when
        int count = strikeService.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isZero();
    }

    @Test
    void count_oneStrike() {
        //given
        computerBaseball.setValues(IntegerListUtil.parseIntegerList("123"));
        inputBaseball.setValues(IntegerListUtil.parseIntegerList("156"));

        //when
        int count = strikeService.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isOne();
    }
}
