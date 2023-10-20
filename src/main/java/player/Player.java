package player;

import static constant.NumberConstant.MAX_LENGTH;
import static constant.StringConstant.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {

    private List<Integer> playerBaseballNumber = new ArrayList<>();

    public void inputPlayerNumber() {
        List<Integer> playerInputBaseballNumber = new ArrayList<>();
        String[] playerInput = Console.readLine().split("");

        for (String inputNumber : playerInput) {
            addBaseballNumberFromPlayerInput(playerInputBaseballNumber, inputNumber);
        }

        validatePlayerInput(playerInputBaseballNumber);
        playerBaseballNumber = playerInputBaseballNumber;
    }

    private void validatePlayerInput(List<Integer> playerInput) {
        Set<Integer> playerBaseballNumberSet = new HashSet<>(playerInput);

        if (playerInput.size() > MAX_LENGTH) {
            throw new IllegalArgumentException(ONLY_THREE_NUMBER_MESSAGE);
        }

        if (playerBaseballNumberSet.size() < MAX_LENGTH) {
            throw new IllegalArgumentException(NO_DUPLICATE_NUMBER_MESSAGE);
        }
    }

    private void addBaseballNumberFromPlayerInput(List<Integer> playerInputBaseballNumber, String playerInput) {
        try {
            playerInputBaseballNumber.add(Integer.parseInt(playerInput));
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ONLY_NUMBER_MESSAGE);
        }
    }

    public List<Integer> getPlayerBaseballNumber() {
        return playerBaseballNumber;
    }
}
