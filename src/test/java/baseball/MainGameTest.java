package baseball;


import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MainGameTest {

    private MainGame mainGame;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        mainGame = new MainGame();
    }

    @Test
    @DisplayName("힌트 테스트")
    public void hintTest() {
        MainGame game = new MainGame();

        assertEquals("낫싱", game.hint(Arrays.asList(0, 0)));
        assertEquals("1볼", game.hint(Arrays.asList(0, 1)));
        assertEquals("2스트라이크", game.hint(Arrays.asList(2, 0)));
        assertEquals("1볼 1스트라이크", game.hint(Arrays.asList(1, 1)));
    }

    @Test
    @DisplayName("결과 테스트")
    public void resultTest() {
        MainGame game = new MainGame();

        assertFalse(game.result(Arrays.asList(0, 0)));
        assertFalse(game.result(Arrays.asList(1, 1)));
        assertTrue(game.result(Arrays.asList(3, 0)));
    }
}
