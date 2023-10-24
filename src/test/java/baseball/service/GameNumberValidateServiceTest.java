package baseball.service;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.util.ComputerRandomGameNumber;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class GameNumberValidateServiceTest {

    private Computer computer;
    private Player player;
    private final GameNumberValidateService gameNumberValidateService = new GameNumberValidateService();

    @DisplayName("컴퓨터와 사용자의 자리 수를 비교해 숫자를 비교한다. (볼)")
    @ParameterizedTest
    @CsvSource({"123,0","456,0","345,1","314,2","312,3"})
    void gameNumberPlaceValidate(String playerNumber, int ballCount) throws Exception{
        //given
        computer = new Computer(new ComputerRandomGameNumber(List.of(1,2,3)));
        player = new Player(playerNumber);

        //when
        gameNumberValidateService.calculateGameNumber(
                computer.getComputerGameNumber(), player.getPlayerNumber());

        //then
        Assertions.assertThat(gameNumberValidateService.getBallCount()).isEqualTo(ballCount);
    }

}