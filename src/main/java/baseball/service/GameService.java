package baseball.service;

import baseball.model.GameNumber;
import baseball.view.ForInputMessage;
import utils.RandomUtils;

import java.util.List;

public class GameService {
    private static final int START_INCLUSIVE_NUMBER = 1;
    private static final int END_INCLUSIVE_NUMBER = 9;
    private static final int SIZE_NUMBER = 3;

    private RandomUtils randomUtils = new RandomUtils();
    private GameNumber gameNumber = new GameNumber();
    private ForInputMessage forInputMessage = new ForInputMessage();

    private ValidationService validationService = new ValidationService(
            START_INCLUSIVE_NUMBER, END_INCLUSIVE_NUMBER, SIZE_NUMBER);
    private CompareService compareService = new CompareService(gameNumber, SIZE_NUMBER);

    // 컴퓨터 난수 생성
    public void setComputerNumbers() {
        List<Integer> computerNumbers = randomUtils.getRandomNumberList(START_INCLUSIVE_NUMBER,
                END_INCLUSIVE_NUMBER, SIZE_NUMBER);

        gameNumber.setComputerNumbers(computerNumbers);
    }

    // 사용자에게 값 입력 받은 후 유효성 검사 (실패했을 경우 false)
    public void getUserNumbers() {
        String inputNumber = forInputMessage.InputUserNumbers();

        try {
            validationService.inputNumberValidation(inputNumber);
            gameNumber.setPlayerNumber(inputNumber);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    // 사용자가 입력한 값과 컴퓨터의 값 비교 (같으면 true)
    public boolean sameNumbers() {
        int strikeCount = compareService.compareNumbers();

        if (strikeCount == 3) {
            return true;
        }

        return false;
    }


}
