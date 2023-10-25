package baseball.service;

import baseball.domain.computer.Computer;
import baseball.domain.game.Game;
import baseball.domain.player.Player;
import baseball.domain.player.dto.PlayerNumbersDto;
import baseball.domain.player.dto.RetryNumberDto;
import baseball.global.message.RetryMessage;

public class GameService {
    private Player player;
    private final Computer computer;
    private Game game;

    public GameService(Player player, Computer computer, Game game) {
        this.player = player;
        this.computer = computer;
        this.game = game;
    }

    public void createComputerNumber() {
        computer.generateThreeNumber();
    }

    public String getResult(PlayerNumbersDto playerNumbersDto) {
        createPlayerNumbers(playerNumbersDto);
        return game.getPlayerResult();
    }

    public void createPlayerNumbers(PlayerNumbersDto playerNumbersDto) {
        player.createPlayerNumbers(playerNumbersDto.playerNumbers());
    }

    public boolean askRetry(RetryNumberDto retry) {
        String input = retry.number();
        return RetryMessage.compareInput(input);
    }
}
