package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    void 게임_시작_전() {
        Game game = new Game(new RandomBallsGenerator());
        assertEquals(game.getGameState(), GameState.READY);
    }

    @Test
    void 게임_시작() {
        Game game = new Game(new RandomBallsGenerator());
        game.start();
        assertEquals(game.getGameState(), GameState.ON);
    }

    @Test
    void 게임_종료() {
        Game game = new Game(new RandomBallsGenerator());
        game.end();
        assertEquals(game.getGameState(), GameState.OFF);
    }

    @Test
    void 게임_재시작() {
        //given
        Game game = new Game(new RandomBallsGenerator());
        game.end();

        //when
        game.restart();

        //then
        assertEquals(game.getGameState(), GameState.ON);
    }

    @Test
    void 힌트_테스트() {
        Game game = new Game(new TestGenerator());
        game.start();
        assertEquals(game.hint(Balls.from(List.of(1, 2, 3))), String.format("3%s", Hint.STRIKE.value()));
    }
}
