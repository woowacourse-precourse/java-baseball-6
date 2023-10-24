package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Player {

    private List<Integer> playerInput = new ArrayList<>(3);

    public List<Integer> getPlayerInput() {
        return playerInput;
    }

    public void readPlayerInput() {
        String input = readLine();
        playerInput.clear();

        if (input.length() > 3) {
            throw new IllegalArgumentException();
        }

        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                playerInput.add(Character.getNumericValue(ch));
            }
        }
    }

}
