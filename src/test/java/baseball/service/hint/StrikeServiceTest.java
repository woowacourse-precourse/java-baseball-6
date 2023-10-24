package baseball.service.hint;

import baseball.domain.Baseball;
import baseball.service.hint.StrikeService;
import baseball.util.IntegerListUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StrikeServiceTest {

    private final StrikeService strikeService = StrikeService.getInstance();

    @Test
    void count_zeroStrike() {
        //given
        Baseball computerBaseball = Baseball.createBaseball("123");
        Baseball inputBaseball = Baseball.createBaseball("456");

        //when
        int count = strikeService.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isZero();
    }

    @Test
    void count_zeroStrike_differentPlace() {
        //given
        Baseball computerBaseball = Baseball.createBaseball("123");
        Baseball inputBaseball = Baseball.createBaseball("451");

        //when
        int count = strikeService.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isZero();
    }

    @Test
    void count_oneStrike() {
        //given
        Baseball computerBaseball = Baseball.createBaseball("123");
        Baseball inputBaseball = Baseball.createBaseball("156");

        //when
        int count = strikeService.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isOne();
    }
}
