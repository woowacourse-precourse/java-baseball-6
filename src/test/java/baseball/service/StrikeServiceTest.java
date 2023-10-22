package baseball.service;

import baseball.domain.Baseball;
import baseball.util.IntegerListUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StrikeServiceTest {

    @Test
    void count_zeroStrike() {
        //given
        StrikeService strikeService = StrikeService.getInstance();

        Baseball computerBaseball = new Baseball();
        Baseball inputBaseball = new Baseball();

        computerBaseball.setValues(IntegerListUtil.parseIntegerList("123"));
        inputBaseball.setValues(IntegerListUtil.parseIntegerList("456"));

        //when
        int count = strikeService.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isZero();
    }

    @Test
    void count_oneStrike() {
        //given
        StrikeService strikeService = StrikeService.getInstance();

        Baseball computerBaseball = new Baseball();
        Baseball inputBaseball = new Baseball();

        computerBaseball.setValues(IntegerListUtil.parseIntegerList("123"));
        inputBaseball.setValues(IntegerListUtil.parseIntegerList("156"));

        //when
        int count = strikeService.count(computerBaseball, inputBaseball);

        //then
        assertThat(count).isOne();
    }
}
