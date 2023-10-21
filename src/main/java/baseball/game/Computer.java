package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> randomNums = new ArrayList<>();

    public void genNumbers() {
        randomNums = new ArrayList<>();

        while (randomNums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!randomNums.contains(randomNumber)) {
                randomNums.add(randomNumber);
            }
        }
    }

    public boolean compare(List<Integer> inputList) {

        int strikeCnt = 0;
        int ballCnt = 0;
        boolean winFlag = false;

        for(int i=0; i<inputList.size(); i++) {

            //값이 있다면
            if(randomNums.contains(inputList.get(i))){

                //자리가 같다면 strike, 자리는 안 같다면 ball
                if(randomNums.get(i) == inputList.get(i)) {
                    strikeCnt++;
                } else {
                    ballCnt++;
                }
            } else {
                continue;
            }
        }

        if(strikeCnt==0 && ballCnt == 0) {
            System.out.println("낫싱");
        } else if(strikeCnt == 0 && ballCnt != 0){
            System.out.printf("%d볼\n", ballCnt);
        } else if(strikeCnt != 0 && ballCnt == 0) {
            System.out.printf("%d스트라이크\n", strikeCnt);
        } else {
            System.out.printf("%d볼 %d스트라이크\n", ballCnt, strikeCnt);
        }

        if(strikeCnt == 3) {
            winFlag = true;
        }

        return winFlag;
    }

}
