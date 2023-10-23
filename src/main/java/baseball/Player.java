package baseball;

import baseball.utils.PlayMessage;
import baseball.utils.PlayerInputValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private final int MAX_LENGTH = 3;

    private List<Character> playerNumbers = new ArrayList<>();

    public List<Character> getPlayerNumbers() {
        return playerNumbers;
    }

    public void setPlayerNumbers() {
        System.out.print(PlayMessage.INPUT_MESSAGE.getMessage());
        String input = Console.readLine();
        PlayerInputValidator.validatePlayerNumber(input);
        stringToList(input);
    }

    private void stringToList(String numbers) {

        for (int i = 0; i < MAX_LENGTH; i++) {
            this.playerNumbers.add(numbers.charAt(i));
        }

    }

}
