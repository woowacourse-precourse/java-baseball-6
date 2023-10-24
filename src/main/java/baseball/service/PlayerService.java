package baseball.service;

import baseball.domain.Baseballs;
import baseball.domain.Player;
import baseball.util.Converter;

public class PlayerService {

    private final Player player;

    public PlayerService(Player player) {
        this.player = player;
    }

    public void generatePlayerBaseballs(String playerGuess) {
        player.setBaseballs(generateBaseballs(playerGuess));
    }

    private static Baseballs generateBaseballs(String playerGuess) {
        return new Baseballs(Converter.convertStringToBaseballs(playerGuess));
    }
}
