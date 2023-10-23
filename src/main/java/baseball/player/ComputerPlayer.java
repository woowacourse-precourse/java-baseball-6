package baseball.player;

import static baseball.common.Constants.endInclusive;
import static baseball.common.Constants.numDigit;
import static baseball.common.Constants.startInclusive;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ComputerPlayer {
    private HashSet<Integer> computer;

    public ComputerPlayer() {
        pickNumber();
    }

    public void pickNumber() {
        computer = new LinkedHashSet<>();
        while(computer.size() < numDigit) {
            int randomNum = Randoms.pickNumberInRange(startInclusive, endInclusive);
            computer.add(randomNum);
        }
    }

    public void clear() {
        this.computer.clear();
    }

    public List<Integer> getComputerNumber() {
        return computer.stream().collect(Collectors.toList());
    }
}
