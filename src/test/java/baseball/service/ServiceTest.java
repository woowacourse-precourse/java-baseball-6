package baseball.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.domain.TestGenerator;
import baseball.domain.balls.Balls;
import baseball.domain.balls.RandomBallsGenerator;
import baseball.domain.game.Game;
import baseball.domain.game.GameState;
import baseball.domain.score.Hint;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ServiceTest {
    @Test
    void start_test() {
        //given
        Game game = new Game(new RandomBallsGenerator());
        Service service = new Service(game);

        //when
        service.startGame();

        //then
        assertEquals(service.getGameState(), GameState.ON);
    }

    @Test
    void hint_test() {
        //given
        TestGenerator testGenerator = new TestGenerator(Balls.from(List.of(1, 2, 3)));
        Game game = new Game(testGenerator);
        Service service = new Service(game);
        service.startGame();

        //when
        Balls input = Balls.from(List.of(1, 2, 3));
        String hint = service.hint(input);

        //then
        assertEquals(hint, String.format("%d%s", 3, Hint.STRIKE.value()));
    }

    @Test
    void end_test() {
        //given
        Game game = new Game(new RandomBallsGenerator());
        Service service = new Service(game);

        //when
        service.endGame();

        //then
        assertEquals(service.getGameState(), GameState.OFF);
    }

    @Test
    void restart_test() {
        //given
        Game game = new Game(new RandomBallsGenerator());
        Service service = new Service(game);

        //when
        service.restartGame();

        //then
        assertEquals(service.getGameState(), GameState.ON);
    }
}
