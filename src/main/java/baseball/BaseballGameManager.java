package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameManager {
    private static BaseballGameManager baseballGameManager;
    private List<Integer> computerNumber = new ArrayList<>();

    private BaseballGameManager() {}

    public static BaseballGameManager getInstance() {
        if(baseballGameManager == null) {
            baseballGameManager = new BaseballGameManager();
        }
        return baseballGameManager;
    }

    public void run() {
        generateRandomNumber();
    }

    private void generateRandomNumber() {
        computerNumber.clear();

        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }
}