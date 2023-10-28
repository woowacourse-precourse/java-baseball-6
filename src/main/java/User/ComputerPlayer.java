package User;

import java.util.List;
import Util.NumberGenerator;

public class ComputerPlayer {
    private final List<Integer> numbers;

    public ComputerPlayer() {
        this.numbers = NumberGenerator.generateRandomNumbers();
    }
    public int[] getNumbersArray() {
        return numbers.stream().mapToInt(i -> i).toArray();
    }

    public void resetNumbers(){
        numbers.clear();
        numbers.addAll(NumberGenerator.generateRandomNumbers());
    }
}