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
    @DisplayName("스트라이크 개수 테스트")
    void countStrikeTest(){
        List<Integer> actual = List.of(1, 2, 3);
        List<Integer> expect = List.of(1, 4, 3);

        int[] result = baseballReferee.scoreInput(expect, actual);

        assertEquals(2, result[1]);
    }

    @Test
    @DisplayName("볼과 스트라이크 개수 테스트")
    void countBallAndStrikeTest(){
        List<Integer> actual = List.of(1, 2, 3);
        List<Integer> expect = List.of(1, 3, 4);

        int[] result = baseballReferee.scoreInput(expect, actual);

        assertEquals(1, result[0]);
        assertEquals(1, result[1]);
    }

    @Test
    @DisplayName("낫싱 테스트")
    void countNoBallAndStrikeTest(){
        List<Integer> actual = List.of(1, 2, 3);
        List<Integer> expect = List.of(4, 5, 6);

        int[] result = baseballReferee.scoreInput(expect, actual);

        assertEquals(0, result[0]);
        assertEquals(0, result[1]);
    }
}