package baseball;

import java.util.ArrayList;
import java.util.List;

public class CpuNumber {

    private List<Integer> cpuNumber;

    public CpuNumber(int number1, int number2, int number3) {
        cpuNumber = new ArrayList<>();
        validateContains(number1, number2, number3);
    }

    private void validateContains(int number1, int number2, int number3) {
        if (!cpuNumber.contains(number1)) {
            cpuNumber.add(number1);
        } else if (!cpuNumber.contains(number2)) {
            cpuNumber.add(number2);
        } else if (!cpuNumber.contains(number3)) {
            cpuNumber.add(number3);
        }
    }

    public List<Integer> getCPUNumber() {
        return cpuNumber;
    }


}
