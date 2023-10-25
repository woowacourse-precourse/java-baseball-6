package baseball.domain.player;

import java.util.List;

import static baseball.global.exception.ExceptionMessage.INPUT_MUST_BE_THREE_DIFFERENT_NUMBERS;

public class Player {
    private PlayerNumbers playerNumbers;

    public Player(PlayerNumbers playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public void createPlayerNumbers(String numbers) {
        clearNumbers();
        this.playerNumbers.inputNumbers(numbers);
        validateNumbersAreDifferent();
    }

    public void validateNumbersAreDifferent() {
        List<Integer> playerNumbers = this.playerNumbers.getNumbers();
        for(int i = 0; i<playerNumbers.size(); i++) {
            for(int j = 0; j<playerNumbers.size(); j++) {
                if(i == j) continue;
                int firstNum = playerNumbers.get(i);
                int secondNum = playerNumbers.get(j);

                if(firstNum == secondNum) throw new IllegalArgumentException(INPUT_MUST_BE_THREE_DIFFERENT_NUMBERS.getMessage());

            }
        }
    }

    public void clearNumbers() {
        this.playerNumbers.clearPlayerNumbers();
    }

    public List<Integer> getPlayerThreeNumbers() {
        return playerNumbers.getNumbers();
    }
}
