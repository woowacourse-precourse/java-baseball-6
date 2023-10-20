package baseball.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComputerNumber {
    private static final int NUMBER_RANGE_MAX = 9;
    private List<Integer> computerNumber;
    private int[] computerNumberIndex;

    public ComputerNumber(List<Integer> number) {
        computerNumber = new ArrayList<>(number);
        initIndex();
    }

    private void initIndex() {
        computerNumberIndex = new int[NUMBER_RANGE_MAX];
        for(int i=0; i<computerNumber.size(); i++) {
            computerNumberIndex[computerNumber.get(i)] = i+1;
        }
    }

    public List<Integer> getComputerNumber() {
        return new ArrayList<>(computerNumber);
    }

    public int[] getComputerNumberIndex() {
        return computerNumberIndex.clone();
    }
}
