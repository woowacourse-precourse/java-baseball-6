package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class ComputerGame {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUM_COUNT = 3;
    private List<Integer> numbers;
    public List<Integer> randomNumber(){
        // 컴퓨터의 숫자 랜덤으로 3자리 뽑아내기
        numbers = new ArrayList<>(); // 실행시킬때마다 다르게 변경
        while(numbers.size() < NUM_COUNT){ // 0, 1, 2 => 3자리
            int randomNum = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER); // 1~9에서 랜덤
            if(!numbers.contains(randomNum)){ //
                numbers.add(randomNum);
            }
        }
        return new ArrayList<>(numbers);
    }

}
