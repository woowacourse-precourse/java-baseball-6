package baseball.model;

import java.util.List;
import java.util.stream.Collectors;

public class GameNumber {
    private List<Integer> playerNumbers;
    private List<Integer> computerNumbers;

    public void setPlayerNumber(String inputNumber) {
        this.playerNumbers = inputNumber.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    public void setComputerNumbers(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
        System.out.println(computerNumbers.get(0).toString() + computerNumbers.get(1).toString() + computerNumbers.get(2).toString());
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
