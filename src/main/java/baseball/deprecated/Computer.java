package baseball.deprecated;

import java.util.List;

public class Computer {
    public List<Integer> getComputerList() {
        return computerList;
    }
    private final List<Integer> computerList;

    public Computer(List<Integer> computerList) {
        this.computerList = computerList;
    }

}
