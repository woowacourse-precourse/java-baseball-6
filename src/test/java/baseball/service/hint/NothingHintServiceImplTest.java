package baseball.service.hint;

import baseball.domain.NumberBaseball;
import baseball.domain.hint.Ball;
import baseball.domain.hint.HintItem;
import baseball.domain.hint.Nothing;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NothingHintServiceImplTest {

    private final NothingHintServiceImpl nothingHintServiceImpl = NothingHintServiceImpl.getInstance();

    @Test
    void create() {
        NumberBaseball computerBaseball = NumberBaseball.createBaseball("123");
        NumberBaseball inputBaseball = NumberBaseball.createBaseball("456");

        HintItem nothingHint = nothingHintServiceImpl.create(computerBaseball, inputBaseball);

        assertTrue(nothingHint instanceof Nothing);
    }

    @Test
    void count_zeroNothing() {
        //given
        NumberBaseball computerBaseball = NumberBaseball.createBaseball("123");
        NumberBaseball inputBaseball = NumberBaseball.createBaseball("456");

        //when
        int count = nothingHintServiceImpl.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isZero();
    }

    @Test
    void count_oneNothing() {
        //given
        NumberBaseball computerBaseball = NumberBaseball.createBaseball("123");
        NumberBaseball inputBaseball = NumberBaseball.createBaseball("416");

        //when
        int count = nothingHintServiceImpl.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isOne();
    }

}
