package model;

import java.util.List;

public class BallCounter {
    private final int number = 3;
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
