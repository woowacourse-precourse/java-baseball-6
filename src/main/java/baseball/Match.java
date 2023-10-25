package baseball;

import java.util.List;

public class Match {


    public static int matchcount(List<Integer> answer, List<Integer> input){         //Input 값과 Answer값이 맞는지 대조 후 볼과 스트라이크 개수를 반환
        int check = 0;
        for(int i =0; i<answer.size(); i++){
            if(answer.contains(input.get(i)))
                check++;
        }
        return check;           //몇개가 맞는지 확인
    }

    public static int strike(List<Integer> answer, List<Integer> input){
        int check = 0;
        for(int i=0; i<answer.size(); i++){
            if(answer.get(i)==input.get(i))
                check++;
        }
        return check;          // 몇개가 스트라이크인지 확인
    }


}
