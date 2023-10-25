package baseball.startProcess;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class startProcess {
    List<Integer> computer;

    public startProcess() {
        printStartPhrase();
        combineThreeComputerNumber();
    }

    private void printStartPhrase() {
        System.out.println(startNotice.startPhrase);
    }

    private void combineThreeComputerNumber() {
        computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNumber() {
        return computer;
    }
}
