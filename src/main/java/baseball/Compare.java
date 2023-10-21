package baseball;

import java.util.List;

public class Compare {
    ComputerNum computer = new ComputerNum();
    UserNum user = new UserNum();

    int entire = 0;
    int ball = 0;
    int strike = 0;

    public int[] compareNumber(List<String> computerNumList, List<String> userNumList) {
        entireCount(computerNumList, userNumList);
        strikeCount(computerNumList, userNumList);
        ballCount();

        return new int[]{ball, strike};
    }

    public void entireCount(List<String> computerNumList, List<String> userNumList) {
        for (int i = 0; i < computerNumList.size(); i++) {
            if (computerNumList.contains(userNumList.get(i))) {
                entire++;
            }
        }
    }

    public void strikeCount(List<String> computerNumList, List<String> userNumList) {
        for (String userNum : userNumList) {
            if (userNumList.indexOf(userNum) == computerNumList.indexOf(userNum)) {
                strike++;
            }
        }
    }

    public void ballCount() {
        ball = entire - strike;
    }
}
