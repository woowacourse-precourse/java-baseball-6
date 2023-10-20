package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class GameManager {
    private static GameManager gameManager;
    public static GameManager getInstance() {
        if (gameManager == null) gameManager = new GameManager();
        return gameManager;
    }

    public void startGame() {
        List<String> answerNumber = generateRandomNumber();
        while (true) {
            break;
        }
    }

    private List<String> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3)
                .stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }
}
