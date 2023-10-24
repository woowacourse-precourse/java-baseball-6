package baseball.service.hint;

import baseball.domain.NumberBaseball;
import baseball.domain.hint.HintItem;
import baseball.domain.hint.Strike;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StrikeHintServiceImplTest {

    private final StrikeHintServiceImpl strikeHintServiceImpl = StrikeHintServiceImpl.getInstance();

    @Test
    void create() {
        NumberBaseball computerBaseball = NumberBaseball.createBaseball("123");
        NumberBaseball inputBaseball = NumberBaseball.createBaseball("456");

        HintItem strikeHint = strikeHintServiceImpl.create(computerBaseball, inputBaseball);

        assertTrue(strikeHint instanceof Strike);
    }

    @Test
    void count_zeroStrike() {
        //given
        NumberBaseball computerBaseball = NumberBaseball.createBaseball("123");
        NumberBaseball inputBaseball = NumberBaseball.createBaseball("456");

        //when
        int count = strikeHintServiceImpl.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isZero();
    }

    @Test
    void count_zeroStrike_differentPlace() {
        //given
        NumberBaseball computerBaseball = NumberBaseball.createBaseball("123");
        NumberBaseball inputBaseball = NumberBaseball.createBaseball("451");

        //when
        int count = strikeHintServiceImpl.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isZero();
    }

    @Test
    void count_oneStrike() {
        //given
        NumberBaseball computerBaseball = NumberBaseball.createBaseball("123");
        NumberBaseball inputBaseball = NumberBaseball.createBaseball("156");

        //when
        int count = strikeHintServiceImpl.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isOne();
    }
}
