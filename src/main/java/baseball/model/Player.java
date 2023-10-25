package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> playerNumber = new ArrayList<>();

    public void createPlayerNumber(String number) {
        playerNumber.clear();
        for (int i = 0; i < number.length(); i++) {
            char charDigit = number.charAt(i);
            int digit = Character.getNumericValue(charDigit);
            playerNumber.add(digit);
        }
    }

    public List<Integer> getPlayerNumber() {
        return playerNumber;
    }
}
