package baseball.service;

import baseball.domain.Baseball;
import baseball.domain.GameConstants;
import baseball.util.ObjectUtil;

import java.util.List;

public class BallService {

    private static final BallService ballService = new BallService();

    public static BallService getInstance(){
        return ballService;
    }

    private BallService() {

    }

    public int count(Baseball computerBaseball, Baseball inputBaseball) {
        int count = 0;
        List computer = computerBaseball.getValues();
        List input = inputBaseball.getValues();

        for (int i = 0; i < GameConstants.NUMBER_LENGTH; i++) {
            for (int j = 0; j < GameConstants.NUMBER_LENGTH; j++) {
                if (i == j) {
                    continue;
                }
                if (ObjectUtil.isSame(computer.get(i), input.get(j))) {
                    count++;
                }
            }
        }

        return count;
    }



}
