package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    List<Integer> computerNumbers = Arrays.asList(1, 2, 3); // 컴퓨터 넘버 정의

    Result result = new Result(); // Result 객체 정의

    @Test
    @DisplayName("모든 숫자가 일치하는 경우 스트라이크 확인")
    void testCheckStrike_AllDigitsMatch() {
        // Given
        String input = "123";

        // When
        int strike = result.checkStrike(input, computerNumbers);

        // Then
        assertEquals(3, strike);
    }

    @Test
    @DisplayName("모든 숫자가 포함된 경우 볼 확인")
    void testCheckBall_AllDigitsContained() {
        // Given
        String input = "312";

        // When
        int ball = result.checkBall(input, computerNumbers);

        // Then
        assertEquals(3, ball);
    }

    @Test
    @DisplayName("결과 상태 확인")
    void testSetResultState_AllResultStates() {
        // Given
        result.checkStrike("123", computerNumbers);
        result.checkBall("123", computerNumbers);

        // When
        result.setResultState();

        // Then
        assertEquals(ResultState.THREE_STRIKE, result.getResultState());
    }
}