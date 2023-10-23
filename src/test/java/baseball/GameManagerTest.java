package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameManagerTest {

    private GameManager gameManager;
    private ResultMapper resultMapper;


    @BeforeEach
    void given() {
        resultMapper = new ResultMapper();
        gameManager = new GameManager(resultMapper);
    }

    @Test
    @DisplayName("게임 종료 조건을 충족하는 경우 테스트")
    public void testGameIsOver(){
        //given
        boolean isGameOver = gameManager.verifyGameState(new Result(3, 3));

        //when
        gameManager.playGame("123", Arrays.asList(1,2,3));

        //then
        gameManager.verifyGameState(new Result(3, 3));
        assertTrue(isGameOver);

    }

}