package baseball.startProcess;

import baseball.GameRole;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class StartProcess {
    private List<Integer> computer;

    public StartProcess(GameRole gameRole) {
        initVariable();
        printStartPhrase();
        inputComputerNumber(gameRole);
    }

    public void resetGame(GameRole gameRole) {
        computer = new ArrayList<>();
        inputComputerNumber(gameRole);
    }

    private void initVariable() {
        computer = new ArrayList<>();
    }

    private void printStartPhrase() {
        System.out.println(StartNotice.startPhrase);
    }

    private void inputComputerNumber(GameRole gameRole) {
        while (computer.size() < gameRole.GAME_NUMBER_CNT) {
            int randomNumber = Randoms.pickNumberInRange(gameRole.GAME_NUMBER_RANGE_OVER, gameRole.GAME_NUMBER_RANGE_UNDER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNumber() {
        return computer;
    }
}
