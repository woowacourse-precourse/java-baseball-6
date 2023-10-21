package baseball.service;

import baseball.domain.InputValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerService {
    public String inputGuessNumber() {
        String input = Console.readLine();
        InputValidator.validateDigitCount(input);

        return input;
    }

    public List<Integer> assignPlayerNums(String guessNumber) {
        List<Integer> playerNums = guessNumber.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());

        return playerNums;
    }

    public String inputGameCommand() {
        String input = Console.readLine();
        InputValidator.validateCommand(input);

        return input;
    }
}
