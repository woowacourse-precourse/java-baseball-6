package baseball.service;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.Rule;
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

    public void comparePlayerWithComputer() {
        for (int i = 0; i < Rule.MAX_LENGTH; i++) {
            int playerNumber = player.getNumbers().get(i);
            int computerNumber = computer.getNumbers().get(i);

            if (isStrike(playerNumber, computerNumber)) {
                player.addStrikeCount();
                continue;
            }
            if (isBall(playerNumber)) {
                player.addBallCount();
            }
        }
    }

    private boolean isStrike(int playerNumber, int computerNumber) {
        return playerNumber == computerNumber;
    }

    private boolean isBall(int playerNumber) {
        return computer.getNumbers().contains(playerNumber);
    }

    private List<Integer> stringToIntegerList(String stringNumber) {
        List<Integer> numberList = stringNumber.chars()
                .map(Character::getNumericValue).boxed()
                .collect(Collectors.toList());

        return numberList;
    }
}
