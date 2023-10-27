package baseball.model;

import baseball.service.PlayerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    PlayerService playerService = new PlayerService();

    @Test
    @DisplayName("플레이어_크기_테스트")
    public void sizeTest() {
        String input = "123";
        List<Integer> list = playerService.createPlayerList(input);
        Player player = new Player(list);
        assertThat(player.getPlayer().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("플레이어_숫자0을포함_테스트")
    public void containsZeroTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            String zeroNumbers = "089";
            List<Integer> list = playerService.createPlayerList(zeroNumbers);
            Player player = new Player(list);
        }, "플레이어는 1 ~ 9 사이의 숫자만 선택해야 합니다.");
    }

    @Test
    @DisplayName("플레이어_중복포함_테스트")
    public void duplicateTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            String zeroNumbers = "188";
            List<Integer> list = playerService.createPlayerList(zeroNumbers);
            Player player = new Player(list);
        }, "플레이어는 1 ~ 9 사이의 숫자만 선택해야 합니다.");
    }

    @Test
    @DisplayName("플레이어_숫자여부_테스트")
    public void isNumberTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            String containsString = "1a3";
            List<Integer> numbers = playerService.createPlayerList(containsString);
            Player player = new Player(numbers);
        } , "플레이어는 숫자 이외의 값을 선택할 수 없습니다.");
    }
}