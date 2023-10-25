package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest extends NsTest {

    @Test
    public void 세개의_각기다른_숫자생성_테스트() throws Exception {
        Game game = new Game();
        game.init();

        // then
        Assertions.assertThat(game.getNumbers().size()).isEqualTo(3);
        Assertions.assertThat(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)).containsAll(game.getNumbers());
        Assertions.assertThat(new HashSet<Integer>(game.getNumbers()).size()).isEqualTo(3);
    }

    @Test
    public void 스트라이크_볼을_판별하는_기능_테스트() throws Exception {
        // given
        List<List<Integer>> answer = new ArrayList<>();
        Game game = new Game(List.of(1, 2, 3));
        List<Integer> prediction1 = List.of(1, 2, 3); // 3S
        List<Integer> prediction2 = List.of(1, 2, 4); // 2S
        List<Integer> prediction3 = List.of(5, 2, 4); // 1S
        List<Integer> prediction4 = List.of(3, 2, 1); // 1S 2B
        List<Integer> prediction5 = List.of(3, 2, 6); // 1S 1B
        List<Integer> prediction6 = List.of(5, 8, 6); // NOTHING

        // when
        game.countStrikeOrBall(prediction1);
        answer.add(List.of(game.getNumberOfStrike(), game.getNumberOfBall()));
        game.countStrikeOrBall(prediction2);
        answer.add(List.of(game.getNumberOfStrike(), game.getNumberOfBall()));
        game.countStrikeOrBall(prediction3);
        answer.add(List.of(game.getNumberOfStrike(), game.getNumberOfBall()));
        game.countStrikeOrBall(prediction4);
        answer.add(List.of(game.getNumberOfStrike(), game.getNumberOfBall()));
        game.countStrikeOrBall(prediction5);
        answer.add(List.of(game.getNumberOfStrike(), game.getNumberOfBall()));
        game.countStrikeOrBall(prediction6);
        answer.add(List.of(game.getNumberOfStrike(), game.getNumberOfBall()));

        // then
        Assertions.assertThat(answer).asList().isEqualTo(List.of(List.of(3, 0), List.of(2, 0), List.of(1, 0), List.of(1, 2), List.of(1, 1), List.of(0, 0)));
    }



    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}