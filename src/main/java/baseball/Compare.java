package baseball;

import java.util.List;public class Compare {
    public int[] compareNumbers(List<String> computerNumList, List<String> userNumList) {
        int entire = entireCount(computerNumList, userNumList);
        int strike = strikeCount(computerNumList, userNumList);
        int ball = entire - strike;

        return new int[] {ball, strike};
    }

    public int entireCount(List<String> computerNumList, List<String> userNumList) {
        int entire = 0;
        for (String userNum : userNumList) {
            if (computerNumList.contains(userNum)) {
                entire++;
            }
        }
        return entire;
    }

    public int strikeCount(List<String> computerNumList, List<String> userNumList) {
        int strike = 0;
        for (String userNum : userNumList) {
            if (userNumList.indexOf(userNum) == computerNumList.indexOf(userNum)) {
                strike++;
            }
        }
        return strike;
    }
}

