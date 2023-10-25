package baseball.service.hint.item;

import baseball.domain.NumberBaseball;
import baseball.domain.hint.item.HintItem;
import baseball.domain.hint.item.Nothing;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NothingServiceImplTest {

    private final NothingServiceImpl nothingServiceImpl = NothingServiceImpl.getInstance();

    @Test
    void create() {
        NumberBaseball computerBaseball = NumberBaseball.createBaseball("123");
        NumberBaseball inputBaseball = NumberBaseball.createBaseball("456");

        HintItem nothingHint = nothingServiceImpl.create(computerBaseball, inputBaseball);

        assertTrue(nothingHint instanceof Nothing);
    }

    @Test
    void count_zeroNothing() {
        //given
        NumberBaseball computerBaseball = NumberBaseball.createBaseball("123");
        NumberBaseball inputBaseball = NumberBaseball.createBaseball("456");

        //when
        int count = nothingServiceImpl.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isZero();
    }

    @Test
    void count_oneNothing() {
        //given
        NumberBaseball computerBaseball = NumberBaseball.createBaseball("123");
        NumberBaseball inputBaseball = NumberBaseball.createBaseball("416");

        //when
        int count = nothingServiceImpl.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isOne();
    }

}
