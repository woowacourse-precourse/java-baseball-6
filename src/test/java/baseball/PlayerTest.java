package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class PlayerTest {
    Player player = new Player();

    @Test
    void 유저_숫자_배열_리스트_변환_테스트() {
        int[] inputPlayerNumbers = {1, 2, 3};
        player.settingPlayerNumber(inputPlayerNumbers);
        List<Integer> result = Arrays.asList(1, 2, 3);

        Assertions.assertThat(result).isEqualTo(player.playerNumberStore);
    }

    @Test
    void 유저_숫자_가져오기_테스트() {
        int[] inputPlayerNumbers = {1, 2, 3};
        player.settingPlayerNumber(inputPlayerNumbers);
        int playerNumber = player.getPlayerNumber(2);

        Assertions.assertThat(3).isEqualTo(playerNumber);
    }

    @Test
    void 유저_숫자_초기화_테스트() {
        int[] inputPlayerNumbers = {1, 2, 3};
        player.settingPlayerNumber(inputPlayerNumbers);
        player.clearPlayerNumberStore();

        Assertions.assertThat(0).isEqualTo(player.playerNumberStore.size());
    }
}