package data;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public final class ComputerNumber extends BaseballNumber {
    public ComputerNumber() throws IllegalArgumentException{
        this.numbers = Randoms.pickUniqueNumbersInRange(1,9,3);
    }

    public ComputerNumber(int first, int second, int third){
        this.numbers = new ArrayList<>();
        List<Integer> numbers = this.numbers;
        numbers.add(first);
        numbers.add(second);
        numbers.add(third);
    }

    public ComputerNumber(List<Integer> sequence) throws IllegalArgumentException{
        if(sequence.size() != 3)
            throw new IllegalArgumentException();
        this.numbers = new ArrayList<>();
        List<Integer> numbers = this.numbers;
        for(int number : sequence)
            numbers.add(number);
    }
}
