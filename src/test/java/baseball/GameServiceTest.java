package baseball;

import baseball.model.GameScoreDTO;
import baseball.service.GameService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class GameServiceTest {
    @Test
    void 볼_테스트() {
        List<Integer> computer = List.of(1,2,3);
        List<Integer> user = List.of(2,3,1);

        GameService gameService = new GameService(computer, user);

        GameScoreDTO gameScoreDTO = gameService.calculate();

        Assertions.assertThat(gameScoreDTO.getStrike()).isEqualTo(0);
        Assertions.assertThat(gameScoreDTO.getBall()).isEqualTo(3);
    }
    @Test
    void 스트라이크_테스트() {
        List<Integer> computer = List.of(1,2,3);
        List<Integer> user = List.of(1,2,4);

        GameService gameService = new GameService(computer, user);

        GameScoreDTO gameScoreDTO = gameService.calculate();

        Assertions.assertThat(gameScoreDTO.getStrike()).isEqualTo(2);
        Assertions.assertThat(gameScoreDTO.getBall()).isEqualTo(0);
    }
    @Test
    void 쓰리_스트라이크_테스트() {
        List<Integer> computer = List.of(1,2,3);
        List<Integer> user = List.of(1,2,3);

        GameService gameService = new GameService(computer, user);

        GameScoreDTO gameScoreDTO = gameService.calculate();

        Assertions.assertThat(gameScoreDTO.getStrike()).isEqualTo(3);
        Assertions.assertThat(gameScoreDTO.getBall()).isEqualTo(0);
    }
    @Test
    void 낫씽_테스트() {
        List<Integer> computer = List.of(1,2,3);
        List<Integer> user = List.of(7,8,9);

        GameService gameService = new GameService(computer, user);

        GameScoreDTO gameScoreDTO = gameService.calculate();

        Assertions.assertThat(gameScoreDTO.getStrike()).isEqualTo(0);
        Assertions.assertThat(gameScoreDTO.getBall()).isEqualTo(0);
    }

}
