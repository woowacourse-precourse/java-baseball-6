package baseball.domain;

import java.util.List;

public class Referee {

    private Computer computer;

    public void newComputerWith(List<Integer> numbers) {
        computer = new Computer(numbers);
    }

    public Judgement judge(Player player, int index) {

        int playerNumber = player.getNumberAt(index);

        if (computer.has(playerNumber)) {

            if (computer.isSameIndex(playerNumber, index)) {
                return Judgement.STRIKE;
            }
            if (!computer.isSameIndex(playerNumber, index)) {
                return Judgement.BALL;
            }
        }
        return Judgement.OUT;
    }
}
