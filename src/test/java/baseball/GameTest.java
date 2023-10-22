package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    void 게임플레이시_결과를_무조건_반환(){
        Game game = new Game(new RandomAnswerFactory(), new ResultFactory());
        String userPredition = "123";

        game.setUpForNewGame();
        Result gameResult = game.play(userPredition);

        assertNotNull(gameResult);
    }
}