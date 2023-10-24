package baseball.Model;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
    /**
     * Model은 Controller와 View에 관련된 코드가 있으면 안된다!!!!!!
     * <p>
     * 본 클래스는 게임의 전체적인데이터와  로직을 관리합니다.
     */
    private List<Integer> computerNumber;
    private Helper helper;
    private static final int BASEBALL_NUM_SIZE = 3;


    public BaseBallGame(Helper helper) {
        this.helper = helper;
        computerNumber = helper.generatorComputerNumber(BASEBALL_NUM_SIZE);
    }

    /**
     * 유저의 입력을 받아 볼과 스트라이크를 알려주는 메소드
     */
    public List<Integer> checkBallCount(List<Integer> userInput) {
        List<Integer> listBallStrike = new ArrayList<>();
        int totalCount = 0;
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < BASEBALL_NUM_SIZE; i++) {
            if (userInput.contains(computerNumber.get(i))) {
                totalCount++;
            }
            if (userInput.get(i) == computerNumber.get(i)) {
                strikeCount++;
            }
        }
        ballCount = totalCount - strikeCount;
        listBallStrike.add(ballCount);
        listBallStrike.add(strikeCount);
        return listBallStrike;
    }

    public boolean checkThreeStrike(List<Integer> listBallStrike) {
        if (listBallStrike.get(1) == BASEBALL_NUM_SIZE) {
            return true;
        }
        return false;
    }
}