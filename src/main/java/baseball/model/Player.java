package baseball.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private void validateDuplicate(List<Integer> player) {
        Set<Integer> duplicateNumbers = new HashSet<>(player);
        if (duplicateNumbers.size() != PLAYER_NUMBERS_SIZE) {
            throw new IllegalArgumentException("컴퓨터는 중복된 숫자를 가질 수 없습니다.");
        }
    }
}
