package baseball.service.hint;

import baseball.domain.Baseball;
import baseball.service.hint.NothingService;
import baseball.util.IntegerListUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NothingServiceTest {

    private final NothingService nothingService = NothingService.getInstance();

    @Test
    void count_zeroNothing() {
        //given
        Baseball computerBaseball = Baseball.createBaseball("123");
        Baseball inputBaseball = Baseball.createBaseball("456");

        //when
        int count = nothingService.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isZero();
    }

    @Test
    void count_oneNothing() {
        //given
        Baseball computerBaseball = Baseball.createBaseball("123");
        Baseball inputBaseball = Baseball.createBaseball("416");

        //when
        int count = nothingService.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isOne();
    }

}
