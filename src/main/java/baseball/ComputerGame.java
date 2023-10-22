package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class ComputerGame {
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 9;
    static final int NUM_COUNT = 3;
    public static void RandomNumber(){
        // 컴퓨터의 숫자 랜덤으로 3자리 뽑아내기
        List<Integer> numberSet = new ArrayList<>(); //
        while(numberSet.size() < NUM_COUNT){ // 0, 1, 2 => 3자리
            int randomNum = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER); // 1~9에서 랜덤
            if(!numberSet.contains(randomNum)){ //
                numberSet.add(randomNum);
            }
        }
    }
}
