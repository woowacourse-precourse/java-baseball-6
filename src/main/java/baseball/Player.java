package baseball;

import java.util.Arrays;
import java.util.List;

public class Player {
    public List<String> convertStringToList(String playerInput) {
        return Arrays.asList(playerInput.split(""));
    }
}
