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

    public List<Integer> convertCharToIntegerList(List<Character> playerInputCharList) {
        List<Integer> playerInputIntegerList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int integerConvertedFromChar = Character.getNumericValue(playerInputCharList.get(i));
            playerInputIntegerList.add(integerConvertedFromChar);
        }

        return playerInputIntegerList;
    }
}
