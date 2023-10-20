package baseball.model;

import java.util.List;

public class Player {

    private static final int PLAYER_NUMBERS_SIZE = 3;
    private final List<Integer> player;

    public Player(List<Integer> player) {
        validateCheckZero(player);
        this.player = player;
    }

    private void validateCheckZero(List<Integer> player) {
        if (player.contains(0)) {
            throw new IllegalArgumentException("플레이어는 1 ~ 9 사이의 숫자만 선택해야 합니다.");
        }
    }
}
