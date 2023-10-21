package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class gameManagerTest {

    @DisplayName("성공적인 재시작/종료 숫자 입력 테스트")
    @Test
    public void successGameMode_test() throws Exception {
        //given
        String input = "1";
        gameManager gameManager = new gameManager();
        //when
        gameManager.setGameMode(input);

        //then
        assertEquals(input, gameManager.getGameMode());
    }

    @DisplayName("잘못된 재시작/종료 숫자 입력 테스트")
    @Test
    public void failGameMode_test() throws Exception {
        //given
        String input = "3";
        gameManager gameManager = new gameManager();
        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            gameManager.setGameMode(input);
        });
    }

}