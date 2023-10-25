package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class GameServiceTest {
    GameService gameService = new GameService();
    Player player = new Player();

    @Test
    void 유저_숫자_컴퓨터_숫자_비교후_스트라이크_카운트_증가_테스트() {
        player.settingPlayerNumber(new int[]{1, 2, 3});
        List<Integer> computer = Arrays.asList(1, 2, 3);

        gameService.computerNumberComparePlayerInputNumber(player, computer);

        Assertions.assertThat(3).isEqualTo(gameService.getStrikeCount());
    }

    @Test
    void 유저_숫자_컴퓨터_숫자_비교후_볼_카운트_증가_테스트() {
        player.settingPlayerNumber(new int[]{3, 1, 2});
        List<Integer> computer = Arrays.asList(1, 2, 5);

        gameService.computerNumberComparePlayerInputNumber(player, computer);

        Assertions.assertThat(2).isEqualTo(gameService.getBallCount());
    }

    @Test
    void 유저_숫자_컴퓨터_숫자_비교후_낫싱_테스트() {
        player.settingPlayerNumber(new int[]{4, 5, 6});
        List<Integer> computer = Arrays.asList(1, 2, 3);

        gameService.computerNumberComparePlayerInputNumber(player, computer);

        Assertions.assertThat(0).isEqualTo(gameService.getStrikeCount());
        Assertions.assertThat(0).isEqualTo(gameService.getBallCount());
    }

    @Test
    void 컴퓨터_랜덤_숫자_길이_테스트() {
        gameService.settingComputerRandomNumbers();
        int size = gameService.getComputerRandomNumberSize();

        Assertions.assertThat(3).isEqualTo(size);
    }

    @Test
    void 정수_배열_변환_테스트() {
        String inputPlayerNumber = "123";
        int[] output = {1, 2, 3};
        int[] result = gameService.toIntArray(inputPlayerNumber);

        Assertions.assertThat(output).isEqualTo(result);
    }

    @Test
    void 정수_변환_테스트() {
        char number = '5';
        int output = 5;
        int result = gameService.toInt(number);

        Assertions.assertThat(output).isEqualTo(result);
    }
}