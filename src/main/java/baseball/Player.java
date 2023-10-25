package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Player {

    public List<Integer> InputplayerNumber() {
        String playerNumber = Console.readLine();

        Validator.isValidatePlayerNumberInput(playerNumber);

        List<Integer> playerNumberList = Arrays.stream(playerNumber.split("")).map(strNum -> Integer.valueOf(strNum)).toList();
        return playerNumberList;
    }
}
