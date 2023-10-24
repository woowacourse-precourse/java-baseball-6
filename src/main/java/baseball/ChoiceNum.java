package baseball;

import java.util.List;

public class ChoiceNum {

    int strike = 0;
    int ball = 0;

    String count = "";

    public ChoiceNum(List<Integer> randomNumList, List<Integer> inputNumList) {
    }

    public String ChoiceNumResult(List<Integer> randomNumList , List<Integer> inputNumList) {

            if (randomNumList.get(0) == inputNumList.get(0)){
                    strike++;
            }
            if (randomNumList.get(1) == inputNumList.get(1)){
                    strike++;
            }
            if (randomNumList.get(2) == inputNumList.get(2)){
                    strike++;
            }

            if (randomNumList.get(0) == inputNumList.get(1) || randomNumList.get(0) == inputNumList.get(2)){
                    ball++;
            }
            if (randomNumList.get(1) == inputNumList.get(0) || randomNumList.get(1) == inputNumList.get(2)){
                    ball++;
            }
            if (randomNumList.get(2) == inputNumList.get(0) || randomNumList.get(2) == inputNumList.get(1)){
                    ball++;
            }

            if (strike == 0 && ball == 0){
                    count = "낫싱";
            } else if (strike != 0 && ball == 0) {
                    count = strike + "스트라이크";
            } else if (strike == 0 && ball != 0) {
                    count = ball + "볼";
            } else {
                    count = ball + "볼 " + strike + "스트라이크";
            }

            return count;
        }
}
