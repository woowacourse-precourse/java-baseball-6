package baseball.global;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerSingleton {

    private final List<Integer> computer;

    private ComputerSingleton() {
        computer = new ArrayList<>();
        generateComputer();
    }

    public static ComputerSingleton getInstance() {
        return ComputerSingletonHolder.INSTANCE;
    }

    public List<Integer> getComputer() {
        return computer;
    }

    public void resetComputer() {
        computer.clear();
        generateComputer();
    }

    private void generateComputer() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    private static class ComputerSingletonHolder {

        private static final ComputerSingleton INSTANCE = new ComputerSingleton();
    }
}
