package baseball.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    @Test
    void 올바른_입력의_재시작_여부(){
        //given
        GameService gameService0 = new GameService();
        GameService gameService1 = new GameService();


        //when,then
        Assertions.assertTrue(gameService0.restart("1"));
        Assertions.assertFalse(gameService1.restart("2"));

    }
}