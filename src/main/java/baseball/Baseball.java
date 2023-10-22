package baseball;

import java.util.ArrayList;
import java.util.List;

public class Baseball {

    public List<Integer> createRandomNumber() {
        List<Integer> computerNums = new ArrayList<>();
        while (computerNums.size() < 3) {
            int num = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1,9);
            if (!computerNums.contains(num)) {
                computerNums.add(num);
            }
        }
        return computerNums;
    }

    public int[] judgeStrikeOrBall(List<Integer> computerNums, String userNums) {
        int[] strikeBallNums = new int[2];
        int strikeCnt = 0;
        int ballCnt = 0;

        for (int i = 0; i < 3; i++) {
            int computerNum = computerNums.get(i);
            int userNum = Integer.parseInt(userNums.substring(i,i+1));

            if (computerNum == userNum) {
                strikeCnt++;
            }
            else if (computerNums.contains(userNum)) {
                ballCnt++;
            }
        }
        strikeBallNums[0] = strikeCnt;
        strikeBallNums[1] = ballCnt;

        return strikeBallNums;
    }
}
