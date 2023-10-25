package baseball;

import java.util.List;

public class Analyzer {


    public boolean analysis(List<Integer> comNum, List<Integer>userNum){
        //TODO: comNum과 userNum 요소쌍 비교

        int strike=0;
        int ball=0;

        for(int i=0;i<3;++i){

            //맞출 경우
            if(comNum.get(i)==userNum.get(i)) continue;

            //못 맞춘 경우
            if(comNum.get(i)!=userNum.get(i)){
                // 못 맞췄지만, 포함된 경우
                if(comNum.contains(userNum.get(i))) {
                    ball++;
                    continue;
                }
                strike++;
            }
        }

        if(strike==0 && ball==0) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        showResult(strike,ball);
        return true;
    }

    public void showResult(int strike, int ball){
        if(ball!=0) System.out.println(ball + "볼 ");
        if(strike!=0) System.out.println(strike + "스트라이크 ");
    }
}
