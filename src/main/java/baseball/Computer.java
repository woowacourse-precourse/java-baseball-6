package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;

public class Computer {
    public static final String NOTTHING = "낫싱";
    public static final String STRIKE = "스트라이크";
    public static final String BOLL = "볼";
    public static final int MAX_DIGIT = 3;
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;
    private ArrayList<Integer> pickNums;
    public Computer(){
        pickNums = new ArrayList<Integer>();
        // 랜덤 값 생성
        while(pickNums.size() < MAX_DIGIT){
            int randomN = Randoms.pickNumberInRange(MIN_NUM,MAX_NUM);
            if(!pickNums.contains(randomN)){
                pickNums.add(randomN);
                System.out.println(randomN);
            }
        }
    }

    // ans와 비교 후 스타라이크 결과 리턴
    public String answerCheck(int checkNum){
        boolean isStrike [] = new boolean[3];
        boolean isBoll [] = new boolean[3];
        Arrays.fill(isStrike, false);

        for(int i=pickNums.size()-1; i >= 0; i--){
            if(checkNum%10 == pickNums.get(i)){
                isStrike[i] = true;
            } else if(pickNums.contains(checkNum%10)){
                isBoll[i] = true;
            }
            checkNum /= 10;
        }

        int bollCount = 0;
        int strikeCount = 0;
        for(int i=0; i< isStrike.length; i++){
            if(isStrike[i]) // 스트라이크 성공
                strikeCount++;
            else if(isBoll[i]){ // 볼 성공
                bollCount++;
            }
        }

        if(strikeCount == 0 && bollCount == 0){
            return NOTTHING;
        }
        else{
            if(strikeCount == MAX_DIGIT){
                return strikeCount + STRIKE;
            }
            else if(bollCount == MAX_DIGIT){
                return bollCount + BOLL;
            }
            else{
                return bollCount + BOLL+ strikeCount + STRIKE;
            }
        }
    }
}
