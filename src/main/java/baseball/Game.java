package baseball;

import static baseball.Message.GAME_START;
import static baseball.Message.INSERT_END_INPUT;
import static baseball.Message.INSERT_GAME_INPUT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int COMPUTER_NUMBERS_SIZE = 3;
    private static final int RANDOM_NUMBER_MIN = 1;
    private static final int RANDOM_NUMBER_MAX = 3;
    private final IOService ioService;

    public Game() {
        this.ioService = new IOService();
    }

    public void run() {
        do {
            ioService.println(GAME_START);
            Numbers computerNumbers = new Numbers(createComputerNumbers());
            Score score = new Score();
            while (score.isUserLose()) {
                GameInput gameInput = new GameInput(ioService.readInput(INSERT_GAME_INPUT));
                Numbers userNumbers = new Numbers(gameInput.convertInputToUserNumbers());
                score = computerNumbers.calculateScore(userNumbers);
                ioService.println(score.getHint());
            }
        } while (new EndInput(ioService.readInput(INSERT_END_INPUT)).isPressResume());
    }

    private List<Integer> createComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < COMPUTER_NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }
}
