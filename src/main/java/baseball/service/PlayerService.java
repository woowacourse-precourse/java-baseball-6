package baseball.service;

import baseball.domain.Baseballs;
import baseball.domain.Player;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlayerService {

    private final Player player;

    public PlayerService(Player player) {
        this.player = player;
    }

    public void generatePlayerBaseballs(String playerGuess) {
        player.setBaseballs(generateBaseballs(playerGuess));
    }

    private Baseballs generateBaseballs(String playerGuess) {
        return new Baseballs(convertStringToBaseballs(playerGuess));
    }

    private List<Integer> convertStringToBaseballs(String playerGuess) {
        if (playerGuess == null || playerGuess.isBlank()) {
            throw new IllegalArgumentException("입력값은 공백이 들어갈 수 없습니다.");
        }

        return IntStream.range(0, playerGuess.length())
                .mapToObj(index -> (playerGuess.charAt(index) - '0'))
                .collect(Collectors.toList());
    }
}
