package baseball.model;

import java.util.List;

public class Player {

    private static final int PLAYER_NUMBERS_SIZE = 3;
    private final List<Integer> player;

    public Player(List<Integer> player) {
        validateCheckZero(player);
        validateSize(player);
        this.player = player;
    }

    private void validateCheckZero(List<Integer> player) {
        if (player.contains(0)) {
            throw new IllegalArgumentException("플레이어는 1 ~ 9 사이의 숫자만 선택해야 합니다.");
        }
    }

    private void validateSize(List<Integer> player) {
        if (player.size() != PLAYER_NUMBERS_SIZE) {
            throw new IllegalArgumentException("플레이어는 3개의 숫자만 선택할 수 있습니다.");
        }
    }
}
