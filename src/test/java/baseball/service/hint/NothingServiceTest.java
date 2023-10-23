package baseball.service.hint;

import baseball.domain.Baseball;
import baseball.service.hint.NothingService;
import baseball.util.IntegerListUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NothingServiceTest {

    private final NothingService nothingService = NothingService.getInstance();
    private Baseball computerBaseball;
    private Baseball inputBaseball;

    @BeforeEach
    void setup() {
        computerBaseball = new Baseball();
        inputBaseball = new Baseball();
    }

    @Test
    void count_zeroNothing() {
        //given
        computerBaseball.setValues(IntegerListUtil.parseIntegerList("123"));
        inputBaseball.setValues(IntegerListUtil.parseIntegerList("456"));

        //when
        int count = nothingService.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isZero();
    }

    @Test
    void count_oneNothing() {
        //given
        computerBaseball.setValues(IntegerListUtil.parseIntegerList("123"));
        inputBaseball.setValues(IntegerListUtil.parseIntegerList("416"));

        //when
        int count = nothingService.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isOne();
    }

}
