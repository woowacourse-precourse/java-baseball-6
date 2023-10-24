package baseball.service;

import baseball.model.GameNumber;
import baseball.view.ForInputMessage;
import baseball.view.OutputMessage;
import utils.RandomUtils;

import java.util.List;

public class GameService {
    private static final int START_INCLUSIVE_NUMBER = 1;
    private static final int END_INCLUSIVE_NUMBER = 9;
    private static final int SIZE_NUMBER = 3;

    private RandomUtils randomUtils = new RandomUtils();
    private GameNumber gameNumber = new GameNumber();
    private OutputMessage outputMessage = new OutputMessage();
    private ForInputMessage forInputMessage = new ForInputMessage();

    private ValidationService validationService = new ValidationService(
            START_INCLUSIVE_NUMBER, END_INCLUSIVE_NUMBER, SIZE_NUMBER);
    private CompareService compareService;

    public void setComputerNumbers() {
        List<Integer> computerNumbers = randomUtils.getRandomNumberList(START_INCLUSIVE_NUMBER,
                END_INCLUSIVE_NUMBER, SIZE_NUMBER);
        gameNumber.setComputerNumbers(computerNumbers);

    }

    // 유효성 검사에 실패했을 경우 false
    public boolean getUserNumbers() {
        String inputNumber = forInputMessage.InputUserNumbers();

        try {
            validationService.inputNumberValidation(inputNumber);
            gameNumber.setPlayerNumber(inputNumber);
            return false;
        } catch (IllegalStateException e) {
            outputMessage.printInputsValidationMessage();
            return true;
        }
    }

    // 사용자의 수와 컴퓨터의 수 비교 후 같으면 true
    public boolean sameNumbers() {
        compareService = new CompareService(gameNumber, SIZE_NUMBER);
        int strikeCount = compareService.compareNumbers();

        if (strikeCount == 3) {
            return true;
        }

        return false;
    }

    // 게임 종료 시 true 반환
    public boolean notRestart() {
        String inputNumber = forInputMessage.InputRestart();

        try {
            return !validationService.inputRestartValidation(inputNumber);
        } catch (IllegalStateException e) {
            outputMessage.printInputsValidationMessage();
            return true;
        }

    }

}
