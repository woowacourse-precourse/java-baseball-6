package baseball;

import java.util.List;

public class ComputeBallStrike {

    public int strikeAndBall(List<Integer> computerNum, List<Integer> userNum){
        int total = 0;
        for (Integer integer : userNum) {
            if (computerNum.contains(integer)) {
                total += 1;
            }
        }
        return total;
    }

    public int strike(List<Integer> computerNum, List<Integer> userNum){
        int strike = 0;
        for (int i = 0 ; i < userNum.size(); i++) {
            if(computerNum.get(i).equals(userNum.get(i))){
                strike += 1;
            }
        }
        return strike;
    }


}
