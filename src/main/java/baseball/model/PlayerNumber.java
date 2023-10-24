package baseball.model;

import baseball.validator.PlayerValidator;

import java.util.ArrayList;
import java.util.List;

public class PlayerNumber {
    private List<Integer> playerNumberList;

    public PlayerNumber() {
        playerNumberList = new ArrayList<>();

    }

    //플레이어가 입력한 숫자 반환
    public List<Integer> getPlayerNumber() {

        return playerNumberList;
    }

    public void setPlayerNumber(String playerInput) {
        if (!isValidInput(playerInput)) {
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다. 3자리 숫자만 입력되어야 합니다.");
        }

        playerNumberList.clear();

        for(int i = 0; i < 3; i++) {
            char digitChar = playerInput.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            playerNumberList.add(digit);
        }

        PlayerValidator.isNumberExistInRange(playerNumberList);
        PlayerValidator.isNumberExistInRange(playerNumberList);
    }

    private boolean isValidInput(String playerInput) {
        // 입력값이 3자리 숫자인지 확인
        return playerInput.matches("^[0-9]{3}$");
    }
}