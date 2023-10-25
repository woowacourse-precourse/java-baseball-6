package baseball.service;

import static baseball.CONSTANT.BALL;
import static baseball.CONSTANT.GAME_SIZE;
import static baseball.CONSTANT.NONE;
import static baseball.CONSTANT.STRIKE;

import baseball.dto.GameResultDTO;
import java.util.List;

public class CheckService {

    public static GameResultDTO matchNumber(List<Integer> userNums, List<Integer> computerNums) {
        int strikeCnt = 0;
        int ballCnt = 0;

        for (int userIdx = 0; userIdx < GAME_SIZE; userIdx++) {
            Integer result = checkCurNumber(userNums.get(userIdx), userIdx, computerNums);
            if (result == STRIKE) {
                strikeCnt++;
            }
            if (result == BALL) {
                ballCnt++;
            }
        }

        GameResultDTO gameResult = new GameResultDTO(strikeCnt, ballCnt, false);

        if (strikeCnt == GAME_SIZE) {
            gameResult.setSuccess(true);
        }

        return gameResult;
    }

    private static Integer checkCurNumber(Integer userNum, Integer userIdx, List<Integer> computerNums) {
        for (int comIdx = 0; comIdx < GAME_SIZE; comIdx++) {
            if (userNum == computerNums.get(comIdx)) {   // 리팩토링 필요.
                if (userIdx == comIdx) {
                    return STRIKE;
                }
                return BALL;
            }
        }
        return NONE;
    }

}
