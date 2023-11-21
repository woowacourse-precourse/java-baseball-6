package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Baseball {
    private List<String> computerNum;

    public Baseball() {
        this.computerNum = pickComputerNum();
    }

    private List<String> pickComputerNum() {
        List<String> computerNum = new ArrayList<>();
        while (computerNum.size() < 3) {
            String randomNum = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!computerNum.contains(randomNum)) {
                computerNum.add(randomNum);
            }
        }
        return computerNum;
    }

    public String getResult(int inputNum) {
        int[] result=countStrikeBall(inputNum);
        int strike=result[1];
        int ball=result[2];

//        String result = resultToString(strike, ball);

    }

    private boolean isStrike(int index,String targetNum){
        return targetNum.equals(computerNum.get(index));
    }

    private boolean isBall(String targetNum){
        return computerNum.contains(targetNum);
    }

    private int[] countStrikeBall(int input){
        int[] result=new int[2];

        String userNum = Integer.toString(input);
        for (int i = 0; i < 3; i++) {
            String targetNum=userNum.substring(i,i+1);
            if (isStrike(i,targetNum)) {
                result[0]++;
                continue;
            }
            if (isBall(targetNum)) {
                result[1]++;
            }
        }
        return result;
    }

    public(int index,int input){

    }
}
