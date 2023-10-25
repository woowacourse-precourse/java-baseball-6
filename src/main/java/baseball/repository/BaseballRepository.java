package baseball.repository;

import java.util.List;

public class BaseballRepository {
    public List<Integer> getComputer() {
        return Computer.getInstance().getComputerNumbers();
    }

    public void saveComputer(List<Integer> numbers) {
        Computer.getInstance().setComputerNumbers(numbers);
    }

}
