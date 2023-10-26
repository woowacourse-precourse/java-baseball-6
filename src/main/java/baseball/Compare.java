package baseball;

import java.util.List;

public class Compare {
    static int ballCount(List<Integer> 컴퓨터, List<Integer> 플레이어){
        int result = 0;
        for (int i = 0; i < 플레이어.size(); i++) {
            if(컴퓨터.contains(플레이어.get(i))){
                result += 1;
            }
        }
        return result;
    }

    static int strikeCount(List<Integer> 컴퓨터, List<Integer> 플레이어){
        int strike = 0;
        for(int i = 0; i < 플레이어.size(); i++){
            if(컴퓨터.get(i)==플레이어.get(i)){
                strike += 1;
            }
        }
        return strike;
    }
}
