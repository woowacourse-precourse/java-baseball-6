package baseball.model;

import java.util.*;
import java.util.regex.Pattern;

public class Player {

    private static final int PLAYER_NUMBERS_SIZE = 3;
    private final List<Integer> player;

    public Player(List<Integer> player) {
        validateCheckZero(player);
        validateSize(player);
        validateDuplicate(player);
        validateIsNumber(player);
        this.player = player;
    }

    public List<Integer> getPlayer() {
        return Collections.unmodifiableList(player);
    }

    private void validateCheckZero(List<Integer> player) {
        if (player.contains(0)) {
            throw new IllegalArgumentException("플레이어는 1 ~ 9 사이의 숫자만 선택해야 합니다.");
        }
    }

    private void validateSize(List<Integer> player) {
        if (player.size() != PLAYER_NUMBERS_SIZE) {
            throw new IllegalArgumentException("플레이어는 2개 미만이나 4개 이상의 숫자를 가질 수 없습니다.");
        }
    }

    private void validateDuplicate(List<Integer> player) {
        Set<Integer> duplicateNumbers = new HashSet<>(player);
        if (duplicateNumbers.size() != PLAYER_NUMBERS_SIZE) {
            throw new IllegalArgumentException("플레이어는 중복된 숫자를 가질 수 없습니다.");
        }
    }

    private void validateIsNumber(List<Integer> player) {
        String pattern = "^[0-9]*$";
        boolean containsNonNumber = player.stream()
                .map(val -> val.toString())
                .anyMatch(s -> !s.matches(pattern));
        if (containsNonNumber) {
            throw new IllegalArgumentException("플레이어는 숫자 이외의 값을 선택할 수 없습니다.");
        }
    }
}
