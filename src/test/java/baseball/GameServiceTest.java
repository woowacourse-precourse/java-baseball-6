package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class GameServiceTest {
    GameService gameService = new GameService();
    Player player = new Player();

    @Test
    void 스트라이크_카운트_증가_테스트() {
        player.settingPlayerNumber(new int[]{1, 2, 3});
        List<Integer> computer = Arrays.asList(1, 2, 3);

        gameService.computerNumberComparePlayerInputNumber(player, computer);

        Assertions.assertThat(3).isEqualTo(gameService.getStrikeCount());
    }

    @Test
    void 볼_카운트_증가_테스트(){
        player.settingPlayerNumber(new int[]{3, 1, 2});
        List<Integer> computer = Arrays.asList(1, 2, 5);

        gameService.computerNumberComparePlayerInputNumber(player, computer);

        Assertions.assertThat(2).isEqualTo(gameService.getBallCount());
    }

    @Test
    void 낫싱_테스트(){
        player.settingPlayerNumber(new int[]{4, 5, 6});
        List<Integer> computer = Arrays.asList(1, 2, 3);

        gameService.computerNumberComparePlayerInputNumber(player, computer);

        Assertions.assertThat(0).isEqualTo(gameService.getStrikeCount());
        Assertions.assertThat(0).isEqualTo(gameService.getBallCount());
    }
}