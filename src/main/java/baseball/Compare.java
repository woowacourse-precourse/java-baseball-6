package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;


public class Compare {
    public String Compare(List<Integer> randomNum, List<Integer> userNum){
        String result="";
        int total = 0;
        int strike = 0;
        //포함된 숫자가 있는지(볼이나 스트라이크 개수 모두 검사)
        for (int i= 0;i<3; i++){
            if (randomNum.contains(userNum.get(i))){
                total++;
            }
        }

        //자리까지 동일한 숫자가 있는지(스트라이크 개수 검사)
        for(int i=0;i<3;i++) {
            if(randomNum.get(i)==userNum.get(i)){
                strike++;
            }
        }


        //출력 문구 전달
        if(total==0){
            result="낫싱";
        }
        else if (strike == 0) {
            result=(total-strike)+"볼";
        }
        else if (strike >= 1 && total==strike){


            result=strike+"스트라이크";
        }
        else //볼과 스트라이크 모두 있는 경우
        {
            result = (total-strike) + "볼 " + strike + "스트라이크";
        }

        return result;
    }
}
