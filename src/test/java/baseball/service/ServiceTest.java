package baseball.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.domain.Balls;
import baseball.domain.Game;
import baseball.domain.Hint;
import baseball.domain.RandomBallsGenerator;
import baseball.domain.TestGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ServiceTest {
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
}
