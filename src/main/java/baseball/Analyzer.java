package baseball;

import java.util.List;

public class Analyzer {


    public boolean analysis(List<Integer> comNum, List<Integer>userNum){
        //TODO: comNum과 userNum 요소쌍 비교

        int strike=0;
        int ball=0;

        for(int i=0;i<3;++i){

            //맞출 경우
            if(comNum.get(i)==userNum.get(i)) strike++;

            //못 맞춘 경우
            if(comNum.get(i)!=userNum.get(i)){
                // 못 맞췄지만, 포함된 경우
                if(comNum.contains(userNum.get(i))) {
                    ball++;
                    continue;
                }
            }
        }

        boolean result = showResult(strike, ball);
        System.out.println();


        return result;
    }

    public boolean showResult(int strike, int ball){
        if(strike==3 && ball==0) {
            System.out.println(strike+"스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }

        if(strike==0 && ball==0) System.out.println("낫싱");
        if(ball!=0) System.out.print(ball + "볼 ");
        if(strike!=0) System.out.print(strike + "스트라이크 ");

        return true;
    }
}
