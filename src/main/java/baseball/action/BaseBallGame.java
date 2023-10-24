package baseball.action;

import java.util.ArrayList;


public class BaseBallGame {
    public static int[] game(ArrayList<Integer> answer, ArrayList<Integer> myNum){
        int strike=0;
        int ball=0;

        //strike, ball 없으면 nothing으로.
        //contain 사용 위해서.
        for(int i=0; i<answer.size(); i++){
            //숫자 가지고 있고&순서 맞고 -> strike
            if(answer.contains(myNum.get(i))&answer.get(i)==myNum.get(i)){
                strike++;
            }
            //숫자 가지고 있기만 하고 -> ball이니까.
            else if(answer.contains(myNum.get(i))){
                ball++;
            }
        }
        //길이 2인 배열
        int[] result=new int[3];
        if(strike==0&ball==0){
            int nothing=1;
            result[2]=nothing;
        } else{
            result[0]=strike;
            result[1]=ball;
        }

        return result;

    }
}
