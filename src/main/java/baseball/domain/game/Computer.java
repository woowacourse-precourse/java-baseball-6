package baseball.domain.game;

import baseball.domain.dto.GameResultDTO;
import java.util.List;

public final class Computer extends GameNumbers {
    private Computer(List<Integer> numbers) {
        super(numbers);
    }

    public static Computer of(List<Integer> numbers) {
        return new Computer(numbers);
    }

    public GameResultDTO evaluateWith(Player player) {
        int ballCount = countBalls(player);
        int strikeCount = countStrikes(player);
        return new GameResultDTO(ballCount, strikeCount);
    }

    private int countBalls(Player player) {
        int ball = 0;
        for (int i = 0; i < GAME_NUMBERS_COUNT; i++) {
            if (isBall(player, i)) {
                ball++;
            }
        }
        return ball;
    }

    private int countStrikes(Player player) {
        int strike = 0;

        for (int i = 0; i < GAME_NUMBERS_COUNT; i++) {
            if (isStrike(player, i)) {
                strike++;
            }
        }
        return strike;
    }

    private boolean isStrike(Player player, int index) {
        GameNumber computerNumber = gameNumbers.get(index);
        GameNumber playerNumber = player.getGameNumberAt(index);
        return computerNumber.equals(playerNumber);
    }

    private boolean isBall(Player player, int index) {
        GameNumber playerNumber = player.getGameNumberAt(index);
        return gameNumbers.contains(playerNumber) && !isStrike(player, index);
    }
}
