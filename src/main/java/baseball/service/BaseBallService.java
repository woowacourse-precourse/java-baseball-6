package baseball.service;

import baseball.common.StringToList;
import baseball.dto.BaseBallResult;
import baseball.model.UserInputNumber;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBallService {
    private static final BaseBallService instance = new BaseBallService();

    public static BaseBallService getInstance() {
        return instance;
    }

    private BaseBallService() {
    }

    public List<Integer> getComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public List<Integer> getUserNumber(String userInputString) {
        try {
            List<Integer> userInput = StringToList.convert(userInputString);
            UserInputNumber userInputNumber = new UserInputNumber(userInput);
            return userInputNumber.getUserInput();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public BaseBallResult compareNumber(List<Integer> computerNumber, List<Integer> userNumber) {
        int strikeCnt = 0;
        int ballCnt = 0;
        boolean isNothing = false;

        boolean[] isStrike = new boolean[computerNumber.size()];

        // strike
        for (int i = 0; i < computerNumber.size(); ++i) {
            if (computerNumber.get(i) == userNumber.get(i)) {
                ++strikeCnt;
                isStrike[i] = true;
            }
        }

        // ball
        for (int i = 0; i < computerNumber.size(); ++i) {
            if ((userNumber.contains(computerNumber.get(i))) && !isStrike[i]) {
                ++ballCnt;
            }
        }

        if ((strikeCnt == 0) && (ballCnt == 0)) {
            isNothing = true;
        }
        return new BaseBallResult(strikeCnt, ballCnt, isNothing);
    }
}
