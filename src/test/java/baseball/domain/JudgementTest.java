package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JudgementTest {

    @Test
    void strikeTest() {
        //given
        boolean isContain = true;
        boolean isInPlace = true;

        //when
        Judgement judge = Judgement.judge(isContain, isInPlace);

        //then
        Assertions.assertThat(judge).isEqualTo(Judgement.STRIKE);
    }

    @Test
    void ballTest() {
        //given
        boolean isContain = true;
        boolean isInPlace = false;

        //when
        Judgement judge = Judgement.judge(isContain, isInPlace);

        //then
        Assertions.assertThat(judge).isEqualTo(Judgement.BALL);
    }

    @Test
    void nothingTest() {
        //given
        boolean isContain = false;
        boolean isInPlace = false;

        //when
        Judgement judge = Judgement.judge(isContain, isInPlace);

        //then
        Assertions.assertThat(judge).isEqualTo(Judgement.NOTHING);
    }
}
