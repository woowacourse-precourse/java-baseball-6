package baseball.model;

import baseball.validator.PlayerValidator;

import java.util.ArrayList;
import java.util.List;

public class PlayerNumber {
    private List<Integer> playerNumberList;

    public PlayerNumber() {
        playerNumberList = new ArrayList<>();
    }

    public List<Integer> getPlayerNumber() {
        return playerNumberList;
    }

    public void setPlayerNumber(String playerInput) {
        playerNumberList.clear();

        try {
            for (int i = 0; i < 3; i++) {
                char digitChar = playerInput.charAt(i);
                int digit = Character.getNumericValue(digitChar);
                playerNumberList.add(digit);
            }
            PlayerValidator.isNumberSizeCorrect(playerNumberList);
            PlayerValidator.isNumberExistInRange(playerNumberList);
            PlayerValidator.isNumberDuplicated(playerNumberList);
        } catch (IllegalArgumentException e) {
            System.out.println("게임 종료: " + e.getMessage());
        }
    }
}
