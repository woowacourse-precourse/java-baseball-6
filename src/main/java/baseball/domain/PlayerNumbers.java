package baseball.domain;

import static baseball.utils.Constants.*;

import baseball.utils.Util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerNumbers {
    private List<Integer> playerNumbers;

    public PlayerNumbers(String playerInput) {
        validateIntType(playerInput);
        this.playerNumbers = Util.convertToIntegerList(playerInput);
        if (!isValidPlayerNumbers()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateIntType(String playerInput) {
        try {
            Integer.parseInt(playerInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidPlayerNumbers() {
        return hasValidCount() && hasValidRange() && hasNoDuplicates();
    }

    private boolean hasValidCount() {
        return playerNumbers.size() == TOTAL_BALL_COUNTS;
    }

    private boolean hasValidRange() {
        return playerNumbers.stream()
                .noneMatch(number -> number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER);
    }

    private boolean hasNoDuplicates() {
        Set<Integer> numberSet = new HashSet<>(playerNumbers);
        return numberSet.size() == playerNumbers.size();
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }
}
