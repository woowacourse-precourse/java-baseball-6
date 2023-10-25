package baseball.util;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerInputParser {
    public List<Integer> parsePlayerInput(String validPlayerInput) {
        return validPlayerInput.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }
}
