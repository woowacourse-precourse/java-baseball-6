package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HintTest {

    @Test
    void 야구_게임_계산(){
        //given
        Hint hint = new Hint();
        Hint hint1 = new Hint();
        Hint hint2 = new Hint();

        //when
        hint.calculateBaseBall(List.of(1,2,3),List.of(7,1,3));
        hint1.calculateBaseBall(List.of(1,4,5),List.of(7,1,3));
        hint2.calculateBaseBall(List.of(7,1,3),List.of(7,1,3));

        //then
        assertEquals(1,hint.getBallCount());
        assertEquals(1,hint.getStrikeCount());

        assertEquals(1,hint1.getBallCount());
        assertEquals(0,hint1.getStrikeCount());

        assertEquals(0,hint2.getBallCount());
        assertEquals(3,hint2.getStrikeCount());
    }


}