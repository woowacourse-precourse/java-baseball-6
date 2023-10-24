package baseball.controller;

import static org.junit.jupiter.api.Assertions.*;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.service.GameNumberValidateService;
import baseball.util.ComputerRandomGameNumber;
import baseball.util.PlayerHintUtil;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GamePlayControllerTest {

    private static Computer computer;
    private static Player player;

    private GameNumberValidateService gameNumberValidateService = new GameNumberValidateService();

    private GamePlayController gamePlayController = new GamePlayController();
    private PlayerHintUtil playerHintUtil = new PlayerHintUtil();

    @DisplayName("플레이어는 숫자를 입력하고 힌트를 얻을 수 있다.")
    @ParameterizedTest
    @CsvSource({"125,낫싱"
            ,"127,1스트라이크","147,2스트라이크"
            ,"123,1볼", "457,1볼 1스트라이크"
            ,"753,2볼", "743,2볼 1스트라이크"
            ,"734,3볼","347,3스트라이크"})
    void getPlayerNumberHintFromComputer(String playerNumber, String hint) throws Exception{
        //given
        computer = new Computer(new ComputerRandomGameNumber(List.of(3,4,7)));
        player = new Player(playerNumber);
        List<Integer> ballAndStrikeList = gameNumberValidateService.calculateGameNumber(
                computer.getComputerGameNumber(), player.getPlayerNumber()
        );

        //when
        gamePlayController.hintResult(ballAndStrikeList);

        //then
        Assertions.assertThat(playerHintUtil.getPlayerHint()).isEqualTo(hint);

    }
}