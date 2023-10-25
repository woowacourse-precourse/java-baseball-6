package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest extends NsTest {

    @Test
    public void 예측에_따른_게임결과_테스트() throws Exception {
        Result result = new Result();
        Game game = new Game(List.of(1, 2, 3));
        List<String> answer = new ArrayList<>();

        game.countStrikeOrBall(List.of(1, 2, 3)); // 3S
        result.setResult(game);
        answer.add(result.getMessage());
        game.countStrikeOrBall(List.of(1, 2, 4)); // 2S
        result.setResult(game);
        answer.add(result.getMessage());
        game.countStrikeOrBall(List.of(5, 2, 4)); // 1S
        result.setResult(game);
        answer.add(result.getMessage());
        game.countStrikeOrBall(List.of(3, 2, 1)); // 1S 2B
        result.setResult(game);
        answer.add(result.getMessage());
        game.countStrikeOrBall(List.of(3, 2, 6)); // 1S 1B
        result.setResult(game);
        answer.add(result.getMessage());
        game.countStrikeOrBall(List.of(5, 8, 6)); // NOTHING
        result.setResult(game);
        answer.add(result.getMessage());
        Assertions.assertThat(answer).asList().isEqualTo(List.of("3스트라이크\n3개 숫자를 모두 맞히셨습니다! 게임 종료\n", "2스트라이크\n", "1스트라이크\n", "2볼 1스트라이크\n", "1볼 1스트라이크\n", "낫싱\n"));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}