package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseballRefereeTest {
    private static BaseballReferee baseballReferee;

    @BeforeAll
    static void setUp(){
        baseballReferee = new BaseballReferee();
    }

    @Test
    @DisplayName("볼 개수 테스트")
    void countBallTest(){
        List<Integer> actual = List.of(1, 2, 3);
        List<Integer> expect = List.of(3, 4, 1);

        int[] result = baseballReferee.scoreInput(expect, actual);

        assertEquals(2, result[0]);
    }

    @Test
    @DisplayName("")
    void countStrikeTest(){

    }
}