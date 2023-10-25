package baseball.startProcess;

import baseball.GameSetting;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class StartProcess {
    private List<Integer> computer;

    public void resetGame(GameSetting gameSetting) {
        initVariable();
        inputComputerNumber(gameSetting);
    }

    public List<Integer> getComputerNumber() {
        return computer;
    }

    public StartProcess(GameSetting gameSetting) {
        initVariable();
        printStartPhrase();
        inputComputerNumber(gameSetting);
    }

    private void initVariable() {
        computer = new ArrayList<>();
    }

    private void printStartPhrase() {
        System.out.println(StartNotice.startPhrase);
    }

    private void inputComputerNumber(GameSetting gameSetting) {
        while (computer.size() < gameSetting.GAME_NUMBER_CNT) {
            int randomNumber = Randoms.pickNumberInRange(gameSetting.GAME_NUMBER_RANGE_OVER, gameSetting.GAME_NUMBER_RANGE_UNDER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}
