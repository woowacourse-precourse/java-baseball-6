package baseball.service;

import baseball.model.Computer;
import baseball.model.Player;
import java.util.List;
import java.util.stream.Collectors;

public class NumberBaseballService {
    private Computer computer;
    private Player player;

    public NumberBaseballService(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public void generateComputerNumbers() {
        computer.generateNumbers();
    }

    public void setPlayerNumbers(String playerNumber) {
        player.setNumbers(stringToIntegerList(playerNumber));
    }

    private List<Integer> stringToIntegerList(String stringNumber) {
        List<Integer> numberList = stringNumber.chars()
                .map(Character::getNumericValue).boxed()
                .collect(Collectors.toList());

        return numberList;
    }
}
