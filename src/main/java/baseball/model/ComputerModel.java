package baseball.model;

import java.util.List;

public class ComputerModel {
    private final List<Integer> computers;

    public ComputerModel(List<Integer> computers) {
        this.computers = computers;
    }

    public List<Integer> getComputers() {
        return computers;
    }
}
