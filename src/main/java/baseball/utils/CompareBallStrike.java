package baseball.utils;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CompareBallStrike {

    //    랜덤 숫자와 사용자 입력 숫자를 비교해 볼, 스트라이크 수 반환
    public static List<Integer> compareComputerNumberAndUserInput(String computerNumber, String userInputNumber) {
        int ball = 0;
        int strike = 0;

        for(int i=0;i<3;i++){
            String nowComNumber = computerNumber.substring(i,i+1);
            for(int j=0; j<3;j++) {
                String nowUserNumber = userInputNumber.substring(j,j+1);
                if(nowUserNumber.equals(nowComNumber)) {
                    if (i == j){
                        strike += 1;
                    }
                    else {
                        ball += 1;
                    }
                }
            }
        }

        return new ArrayList<Integer>(Arrays.asList(ball,strike));
    }
}
