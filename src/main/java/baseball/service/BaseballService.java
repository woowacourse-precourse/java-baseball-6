package baseball.service;

import java.util.List;

public class BaseballService {

    public int checkStrike(String number, List<Integer> computer) {
        int cntStrike = 0;
        String[] str = number.split("");
        for (int i=0; i<3; i++){
            if(Integer.parseInt(str[i]) == computer.get(i))
                cntStrike++;
        }
        return cntStrike;
    }

    public int checkBall(String number, List<Integer> computer) {
        int cntBall = 0;
        for (int i=0; i<3; i++) {
            String num = String.valueOf(computer.get(i));
            if(number.contains(num) && Character.getNumericValue(number.charAt(i)) != computer.get(i)){
                cntBall++;
            }
        }
        return cntBall;
    }

}
