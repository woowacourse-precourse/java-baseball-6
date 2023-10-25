package baseball;

import baseball.constant.ExceptionMessage;
import baseball.constant.GameRule;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private List<Integer> playerNumber;

    public void generatePlayerNumber() {
        try {
            String str = Console.readLine();
            this.playerNumber = Arrays.stream(str.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_ERROR, e);
        }
        checkValidPlayerNumber();
    }

    public List<Integer> getPlayerNumber() {
        return playerNumber;
    }

    public boolean restartOrEnd() {
        String str;
        int restartOrEnd;
        try {
            str = Console.readLine();
            restartOrEnd = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.RESTART_NUMBER_ERROR, e);
        }
        checkValidRestartNumber(restartOrEnd);

        if (restartOrEnd == GameRule.RESTART) {
            return true;
        } else if (restartOrEnd == GameRule.END) {
            return false;
        }
        return false;
    }

    public void checkValidPlayerNumber() {
        for (Integer number : playerNumber) {
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_ERROR);
            }
        }

        if (playerNumber.size() != GameRule.DIGITS_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.LENGTH_ERROR);
        }

        HashSet<Integer> numberSet = new HashSet<>();
        for (Integer number : playerNumber) {
            if (!numberSet.add(number)) {
                throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_ERROR);
            }
        }
    }

    private void checkValidRestartNumber(int restartOrEnd) {
        if (restartOrEnd != GameRule.RESTART && restartOrEnd != GameRule.END) {
            throw new IllegalArgumentException(ExceptionMessage.RESTART_NUMBER_ERROR);
        }
    }
}
