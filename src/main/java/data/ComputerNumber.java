package data;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public final class ComputerNumber extends BaseballNumber {
    public ComputerNumber() throws IllegalArgumentException{
        this.numbers = Randoms.pickUniqueNumbersInRange(1,9,3);
    }

    public ComputerNumber(int first, int second, int third) throws IllegalArgumentException{
        this.numbers = new ArrayList<>();
        List<Integer> numbers = this.numbers;
        numbers.add(first);
        numbers.add(second);
        numbers.add(third);
    }
}
