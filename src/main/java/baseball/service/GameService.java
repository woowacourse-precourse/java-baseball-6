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

    // 컴퓨터 난수 생성
    public void setComputerNumbers() {
        List<Integer> computerNumbers = randomUtils.getRandomNumberList(START_INCLUSIVE_NUMBER,
                END_INCLUSIVE_NUMBER, SIZE_NUMBER);

        gameNumber.setComputerNumbers(computerNumbers);
    }

}
