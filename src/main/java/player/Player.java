package player;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {

    private List<Integer> playerBaseballNumber;
    private static final int MAX_LENGTH = 3;
    private static final String ONLY_THREE_NUMBER_MESSAGE = "3자리의 숫자만 입력가능합니다.";
    private static final String ONLY_NUMBER_MESSAGE = "숫자만 입력 가능합니다.";
    private static final String NO_DUPLICATE_NUMBER_MESSAGE = "중복된 숫자는 입력 불가능합니다.";

    public List<Integer> inputPlayerNumber() {
        List<Integer> playerInputBaseballNumber = new ArrayList<>();
        String[] playerInput = Console.readLine().split("");

        for (String inputNumber : playerInput) {
            addBaseballNumberFromPlayerInput(playerInputBaseballNumber, inputNumber);
        }

        validatePlayerInput(playerInputBaseballNumber);
        playerBaseballNumber = playerInputBaseballNumber;
        return playerInputBaseballNumber;
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
