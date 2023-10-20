package baseball.domain.player;

import static baseball.domain.number.NumberConstant.MAX_NUMBER;
import static baseball.domain.number.NumberConstant.MIN_NUMBER;
import static baseball.domain.number.NumberConstant.NUMBER_COUNT;

import baseball.domain.number.Numbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Computer {
    private  Player player;

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

    public Numbers getNumbers() {
        return player.getNumbers();
    }

    public List<Integer> getNumberList() {
        return player.getNumberList();
    }

}
