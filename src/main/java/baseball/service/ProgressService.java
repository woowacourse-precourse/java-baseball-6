package baseball.service;

import baseball.validation.NumberValidation;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

import static baseball.constant.Constant.*;
import static baseball.message.CountMessage.NOTHING;

public class ProgressService {

    private int[] computerNumber;
    private CountService countService;
    private boolean isEnd = false;

    public ProgressService() {
        resetGame();
    }

    public void resetGame() {
        computerNumber = getComputerNumber();
        countService = new CountService(computerNumber);
        isEnd = false;
    }

    public int[] getComputerNumber() {
        int[] number;
        do {
            number = createComputerNumber();
        } while (!NumberValidation.validateComputerDuplicate(number));
        computerNumber = number;
        return computerNumber;
    }

    private static int[] createComputerNumber() {
        return Arrays.stream(new int[NUMBER_LENGTH])
                .map(i -> Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER))
                .toArray();
    }

    public String getResultMessage(int[] playerNumber) {
        int strikeCount = countService.getStrikeCount(computerNumber, playerNumber);
        int ballCount = countService.getBallCount(computerNumber, playerNumber);
        checkGameStatus(strikeCount, ballCount);
        if (countService.isNothing()) {
            return NOTHING.getMessage();
        }
        return countService.getResultCount(computerNumber, playerNumber);
    }

    public boolean isGameClear() {
        return isEnd;
    }

    public int getResultGameStatus(String input) {
        NumberValidation.validateGameStatus(input);
        if (input.equals("1")) {
            return RESTART;
        }
        return END;
    }

    public void checkGameStatus(int strikeCount, int ballCount) {
        if (strikeCount == 3 && ballCount == 0) {
            this.isEnd = true;
        }
    }
}
