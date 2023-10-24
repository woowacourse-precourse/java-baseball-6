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

    @Test
    void 사용자의_입력과_정답을_비교하여_결과를_반환한다() {
        Game game = new Game();
        game.answerList.clear();
        game.answerList.addAll(List.of(4, 0, 9));

        GameResult gameResult1 = game.getGameResult(List.of(1, 2, 3));
        assertEquals(new GameResult(0, 0), gameResult1);

        GameResult gameResult2 = game.getGameResult(List.of(6, 0, 8));
        assertEquals(new GameResult(1, 0), gameResult2);

        GameResult gameResult3 = game.getGameResult(List.of(0, 4, 9));
        assertEquals(new GameResult(1, 2), gameResult3);

        GameResult gameResult4 = game.getGameResult(List.of(4, 0, 9));
        assertEquals(new GameResult(3, 0), gameResult4);
    }
}
