package baseball.service;

import baseball.view.printGameMessage;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class playerService {
    private final printGameMessage gameMessage = new printGameMessage();

    public List<Integer> selectPlayerNumber() {
        gameMessage.inputNumberMessage();
        String playerNumber = Console.readLine();

        if (playerNumber.length() > gameConstant.NUMBER_MAXSIZE) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }

        List<Integer> playerNumbers = stringToIntArray(playerNumber);
        if (isDuplicate(playerNumbers) || isNotNumberInput(playerNumbers)) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }
        return playerNumbers;
    }

    public boolean isNotNumberInput(List<Integer> playerNumbers) {
        for (Integer playerNumber : playerNumbers) {
            if (playerNumber > 9 || playerNumber < 1) {
                return true;
            }
        }
        return false;
    }

    public boolean isDuplicate(List<Integer> playerNumbers) {
        for (int i = 0; i < playerNumbers.size(); i++) {
            int element = playerNumbers.get(i);
            if (isDuplicateElementInArray(element, playerNumbers)) {
                return true;
            }
        }
        return false;
    }

    public boolean isDuplicateElementInArray(Integer element, List<Integer> playerNumbers) {
        int elementCount = 0;
        for (Integer playerNumber : playerNumbers) {
            if (Objects.equals(playerNumber, element)) {
                elementCount++;
            }
        }
        return elementCount > gameConstant.NOT_DUPLICATE;
    }

    public List<Integer> stringToIntArray(String playerNumber) {
        List<Integer> digits = new ArrayList<>();

        for (int i = 0; i < playerNumber.length(); i++) {
            digits.add(playerNumber.charAt(i) - '0');
        }

        return digits;
    }
}
