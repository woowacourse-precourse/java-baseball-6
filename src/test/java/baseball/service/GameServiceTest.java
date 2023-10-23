package baseball.service;

import baseball.model.GameResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    @BeforeEach
    public void setUp() {
        gameService = new GameService();
    }

    private GameService gameService;

    @DisplayName("컴퓨터 - 사용자 번호 매칭 결과 테스트")
    @Test
    public void testGetResult() {
        List<Integer> comNumber = Arrays.asList(1, 2, 3);
        List<Integer> userNumber = Arrays.asList(3, 2, 1);

        // when
        GameResult result = gameService.getResult(comNumber, userNumber);

        // then
        assertEquals(2, result.getBall());
        assertEquals(1, result.getStrike());
    }

}