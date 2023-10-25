package baseball.service;

import baseball.domain.game.Game;
import baseball.domain.player.dto.PlayerNumbersDto;
import baseball.domain.player.dto.RetryNumberDto;
import baseball.global.message.RetryMessage;

public class GameService {
    private Game game;

    public GameService(Game game) {
        this.game = game;
    }

    public void initNumbers() {
        game.initNumbers();
    }

    public String getResult(PlayerNumbersDto playerNumbersDto) {
        game.inputPlayerNumbers(playerNumbersDto.playerNumbers());
        return game.getPlayerResult();
    }


    public boolean askRetry(RetryNumberDto retry) {
        String input = retry.number();
        return RetryMessage.compareInput(input);
    }


}
