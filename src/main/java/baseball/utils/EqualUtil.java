package baseball.utils;

import java.util.ArrayList;
import java.util.Collections;

public class EqualUtil {

    public static ArrayList<Integer> equalSingleNumber(int userNum){ //TODO. 중복값 처리 분리
        ArrayList<Integer> USER_NUM_LIST = new ArrayList<>();

        while(userNum > 0){
            if(!USER_NUM_LIST.contains(userNum %10)){
                USER_NUM_LIST.add(userNum %10);
            }
            userNum /=10;
        }
        Collections.reverse(USER_NUM_LIST);
        System.out.println("++++" + USER_NUM_LIST);
        return USER_NUM_LIST;
    }

    //Strike
    public static int equalBetweenStrike(ArrayList<Integer> userNumList, ArrayList<Integer> computerNumList){
        int strikeCnt = 0;
        for(int num_i=0; num_i<userNumList.size(); num_i++){
            boolean isStrike = userNumList.get(num_i).equals(computerNumList.get(num_i));
            if(isStrike){
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    //ball
    public static int equalBetweenBall(ArrayList<Integer> userNumList, ArrayList<Integer> computerNumList){
        int ballCnt = 0;

        for(int num_i=0; num_i<userNumList.size(); num_i++){
            if(userNumList.contains(computerNumList.get(num_i))){
                if(!userNumList.get(num_i).equals(computerNumList.get(num_i))){
                    ballCnt++;
                }
            }
        }

        return ballCnt;
    }
}
