package baseball.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatchServiceTest {

    @DisplayName("컴퓨터 - 사용자 번호 매칭 결과 테스트")
    @Test
    public void getResult_test() throws Exception {
        //given
        MatchService matchService = new MatchService();

        List<Integer> comNumber = Arrays.asList(1, 2, 3);
        List<Integer> userNumber = Arrays.asList(1, 3, 2);

        //when
        List<Integer> result = matchService.getResult(comNumber, userNumber);

        //then
        assertEquals(2, result.get(0)); // Expecting 2 balls: number '2' and '3' are in wrong places.
        assertEquals(1, result.get(1)); // Expecting 1 strike: number '1' is in the correct place.
     }

}