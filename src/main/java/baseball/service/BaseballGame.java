package baseball.service;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.utils.Utils;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private Computer computer = new Computer();
    private Player player = new Player();

    public void startGame() {
        setUpBaseballGame();
    }

    public void setUpBaseballGame() {
        computer.setBaseballNumbers(createComputerNumbers());
        List<Integer> playerNumbers = Utils.parseIntegerList(InputView.inputBaseballNumbers());
        player.setBaseballNumbers(playerNumbers);
    }

    private List<Integer> createComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}