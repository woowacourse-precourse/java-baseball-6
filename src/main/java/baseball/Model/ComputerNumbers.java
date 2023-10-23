package baseball.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ComputerNumbers {
    private List<Integer> computerNumbers;

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public void setComputerNumbers(Set<Integer> computerNumbers) {
        this.computerNumbers = new ArrayList<>(computerNumbers);
    }
}
