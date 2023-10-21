package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;

public class Computer {

    private ArrayList<Integer> ans;
    public Computer(){
        ans = new ArrayList<Integer>();
        // 랜덤 값 생성
        while(ans.size() < 3){
            int randomN = Randoms.pickNumberInRange(1,9);
            if(!ans.contains(randomN)){
                ans.add(randomN);
            }
        }
    }

    // ans와 비교 후 스타라이크 결과 리턴
    public String ansCheck(int n){
        boolean isStrike [] = new boolean[3];
        boolean isBoll [] = new boolean[3];
        Arrays.fill(isStrike, false);

        for(int i=ans.size()-1; i >= 0; i--){
            if(n%10 == ans.get(i)){
                isStrike[i] = true;
            } else if(ans.contains(n%10)){
                isBoll[i] = true;
            }
            n /= 10;
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
            return "낫싱";
        }
        else{
            if(strikeCount == 3){
                return strikeCount + "스트라이크";
            } else if(bollCount == 3){
                return bollCount + "볼";
            }
            else{
                return bollCount+"볼 "+ strikeCount + "스트라이크";
            }
        }

    }


}
