package baseball.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComputerNumber {

    public static final int NUMBER_RANGE_MAX = 9;
    private List<Integer> computerNumber;
    private int[] numberIndex;

    public ComputerNumber(List<Integer> computerNumber) {
        this.computerNumber = new ArrayList<>(computerNumber);
        initNumberIndex();
    }

    private void initNumberIndex() {
        numberIndex = new int[NUMBER_RANGE_MAX+1];
        for(int i=0; i<computerNumber.size(); i++) {
            numberIndex[computerNumber.get(i)] = i+1;   //해당 숫자가 저장된 위치를 저장
        }
    }

    public List<Integer> getComputerNumber() {
        return new ArrayList<>(computerNumber);
    }

    public int[] getNumberIndex() {
        return Arrays.copyOf(numberIndex, numberIndex.length);
    }
}
