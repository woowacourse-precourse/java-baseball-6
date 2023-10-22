package baseball.domain;

import static baseball.domain.numbers.NumbersConstant.MAX_NUMBER;
import static baseball.domain.numbers.NumbersConstant.MIN_NUMBER;
import static baseball.domain.numbers.NumbersConstant.NUMBER_COUNT;

import baseball.domain.numbers.Numbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Computer {
    private Player player;

    private Computer() {
    }

    public static Computer create() {
        Computer computer = new Computer();
        computer.setPlayer(Player.create(makeRandomNumbers()));

        return computer;
    }

    private void setPlayer(Player player) {
        this.player = player;
    }


    private static Numbers makeRandomNumbers() {
        List<Integer> numberList = new ArrayList<>();

        while (isNotFull(numberList)) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }

        return Numbers.create(numberList);
    }

    private static boolean isNotFull(List<Integer> numberList) {
        return numberList.size() < NUMBER_COUNT;
    }

    public Player getPlayer() {
        return Player.create(player.getNumbers());
    }
}
