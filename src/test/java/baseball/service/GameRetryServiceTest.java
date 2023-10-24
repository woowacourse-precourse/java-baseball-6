package baseball.service;


import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.PlayerStatus;
import baseball.util.ComputerRandomGameNumber;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameRetryServiceTest {

    private static final GameRetryService gameRetryService = new GameRetryService();

    @DisplayName("플레이어는 게임을 다시 시작할 수 있다.")
    @Test
    void playerRetryNumberGamePlay() throws Exception{
        //given
        Computer computer = new Computer(new ComputerRandomGameNumber(List.of(1, 2, 3)));
        Player player = new Player(1);

        //when
        gameRetryService.setNextGameStatus(computer, player);

        //then
        assertThat(computer.getComputerGameNumber())
                .isNotEqualTo("123");
        assertThat(player.getPlayerStatus()).isNotEqualTo(PlayerStatus.END);
    }

    @DisplayName("플레이어는 게임을 완전 종료할 수 있다.")
    @Test
    void playerRetryNumberGameEnd() throws Exception{
        //given
        Computer computer = new Computer(new ComputerRandomGameNumber(List.of(1, 2, 3)));
        Player player = new Player(2);

        //when
        gameRetryService.setNextGameStatus(computer, player);

        //then
        assertThat(computer.getComputerGameNumber())
                .isEqualTo("123");
        assertThat(player.getPlayerStatus()).isEqualTo(PlayerStatus.END);
    }
}