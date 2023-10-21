package baseball.domain;

import java.util.List;

public class Computer {
    private List<Integer> computerNums;

    public Computer(List<Integer> computerNums) {
        this.computerNums = computerNums;
    }

    public boolean isSameNumber(int number, int index) {
        if (number != computerNums.get(index)) {
            return false;
        }

        return true;
    }

    public boolean isContainNumber(int number) {
        if (!computerNums.contains(number)) {
            return false;
        }

        return true;
    }
}
