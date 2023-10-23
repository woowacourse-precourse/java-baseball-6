package baseball;

import java.util.Arrays;

public class CompareNumber {
    public void compareNumber(int[] inputArr,int[] randomArr){
        int strike = 0;
        int ball = 0;
        for(int i = 0;i<inputArr.length;i++){
            if (Arrays.binarySearch(randomArr,inputArr[i])>= 0){
                ball += 1;
                if(inputArr[i] == randomArr[i]){
                    ball -= 1;
                    strike += 1;
                }
            }
        }
        if(strike!=0 && ball != 0){
            System.out.println(strike+"스트라이크" + ball+"볼");
        } else if(strike!=0){
            System.out.println(strike+"스트라이크");
        } else if(ball!=0){
            System.out.println(ball+"볼");
        } else if (strike==0 && ball == 0) {
            System.out.println("낫싱");
        }

    }
}
