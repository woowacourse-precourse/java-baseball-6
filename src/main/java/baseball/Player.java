package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public List<Character> convertStringToCharList(String playerInput) {
        List<Character> playerInputCharList = new ArrayList<>();

        for (char ch : playerInput.toCharArray()) {
            playerInputCharList.add(ch);
        }

        return playerInputCharList;
    }
}
