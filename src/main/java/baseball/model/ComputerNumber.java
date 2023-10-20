package baseball.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComputerNumber {
    private List<Integer> computerNumber;

    public void setComputerNumber(List<Integer> number) {
        computerNumber = new ArrayList<>(number);
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

}
