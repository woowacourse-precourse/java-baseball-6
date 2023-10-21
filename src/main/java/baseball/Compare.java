package baseball;

import java.util.List;

public class Compare {
    int entire = 0;
    int ball = 0;
    int strike = 0;

    public int[] compareNumber(List<String> computerNumList, List<String> userNumList) {
        entireCount(computerNumList, userNumList);
        strikeCount(computerNumList, userNumList);
        ballCount();

        return new int[]{ball, strike};
    }

    public int entireCount(List<String> computerNumList, List<String> userNumList) {
        for (int i = 0; i < computerNumList.size(); i++) {
            if (computerNumList.contains(userNumList.get(i))) {
                entire++;
            }
        }
        return entire;
    }

    public int strikeCount(List<String> computerNumList, List<String> userNumList) {
        for (String userNum : userNumList) {
            if (userNumList.indexOf(userNum) == computerNumList.indexOf(userNum)) {
                strike++;
            }
        }
        return strike;
    }

    public int ballCount() {
        ball = entire - strike;
        return ball;
    }
}
