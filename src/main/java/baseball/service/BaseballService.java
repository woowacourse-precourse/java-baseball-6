package baseball.service;

import java.util.List;
import java.util.Objects;

public class BaseballService {
    private BaseballService(){}
    private static BaseballService instance = new BaseballService();
    public static BaseballService getInstance(){
        return instance;
    }


    public int[] check(List<Integer> computer, List<Integer> user) {
        if(user.size()!=3)
            throw new IllegalArgumentException("잘못 입력하였습니다.");


        int [] result = new int [2];

        result[0] = strike(computer, user);
        result[1] = ball(computer, user);

        return result;
    }
    public int strike (List<Integer> computer,List<Integer> user){
        int cnt = 0;
        for(int i =0; i<3; i++){
            if(Objects.equals(computer.get(i), user.get(i)))
                cnt++;
        }

        return cnt;
    }

    public int ball (List<Integer> computer,List<Integer> user){
        int cnt = 0;
        for(int i =0; i<3; i++){
            for(int j=0; j<3; j++){
                if(Objects.equals(computer.get(i), user.get(j)) && i!=j)
                    cnt++;
            }
        }

        return cnt;
    }
}
