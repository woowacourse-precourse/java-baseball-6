package baseball.service.hint;

import baseball.domain.NumberBaseball;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NothingServiceTest {

    private final NothingService nothingService = NothingService.getInstance();

    @Test
    void count_zeroNothing() {
        //given
        NumberBaseball computerBaseball = NumberBaseball.createBaseball("123");
        NumberBaseball inputBaseball = NumberBaseball.createBaseball("456");

        //when
        int count = nothingService.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isZero();
    }

    @Test
    void count_oneNothing() {
        //given
        NumberBaseball computerBaseball = NumberBaseball.createBaseball("123");
        NumberBaseball inputBaseball = NumberBaseball.createBaseball("416");

        //when
        int count = nothingService.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isOne();
    }

}
