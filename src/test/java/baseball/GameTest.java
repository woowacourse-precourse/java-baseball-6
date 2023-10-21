package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Game 클래스 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GameTest {

    @Test
    void 랜덤한_정답_리스트를_생성한다() {
        Game game = new Game();
        System.out.println(game.answerList);
    }

    @Test
    void 정답_리스트의_크기는_3이다() {
        Game game = new Game();
        List<Integer> answerList = game.makeRandomAnswer();
        assertEquals(3, answerList.size());
    }

    @Test
    void 정답_리스트의_숫자는_1에서_9사이다() {
        Game game = new Game();
        List<Integer> answerList = game.makeRandomAnswer();
        assertTrue(answerList.stream().allMatch(num -> num >= 1 && num <= 9));
    }

    @Test
    void 정답_리스트의_모든_숫자는_중복되면_안된다() {
        Game game = new Game();
        List<Integer> answerList = game.makeRandomAnswer();
        assertEquals(answerList.size(), answerList.stream().distinct().count());
    }
}
