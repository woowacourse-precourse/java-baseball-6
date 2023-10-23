package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {

    @DisplayName("성공적인 재시작/종료 숫자 입력 테스트")
    @Test
    public void successGameMode_test() throws Exception {
        //given
        String input = "1";
        GameManager gameManager = new GameManager();
        //when
        gameManager.setPlayMode(input);

        //then
        assertEquals(input, gameManager.getGameMode());
    }

    @DisplayName("잘못된 재시작/종료 숫자 입력 테스트")
    @Test
    public void failGameMode_test() throws Exception {
        //given
        String input = "3";
        GameManager gameManager = new GameManager();
        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            gameManager.setPlayMode(input);
        });
    }

}