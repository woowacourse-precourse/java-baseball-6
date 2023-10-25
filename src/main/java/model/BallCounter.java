package model;

import java.util.List;

public class BallCounter {
    // 게임에서 몇 개의 숫자를 가지고 진행할 것인지에 대한 상수 선언
    private final int number = 3;

    /**
     * 볼, 스트라이크, 낫싱을 판단하는 기능
     * 결과를 배열로 리턴해줌
     */
    public int[] ballCount(List<Integer> userNum, List<Integer> comNum){
        int[] answer = new int[2];
        for(int i=0; i<number; i++){
            if(comNum.contains(userNum.get(i))){
                if(comNum.indexOf(userNum.get(i))==i) answer[0]++;
                else answer[1]++;
            }
        }
        return answer;
    }
}
