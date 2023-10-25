package baseball.module.domain;

import static baseball.global.constant.Game.SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Computer {

    private List<Integer> numbers;

    private Computer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Computer generate() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < SIZE) {
            int random = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }
        return new Computer(numbers);
    }

    public Iterator<Integer> getComputerNumbers() {
        return numbers.iterator();
    }

    public boolean contains(int playerNum) {
        if (numbers.contains(playerNum)) {
            return true;
        }
        return false;
    }
}
