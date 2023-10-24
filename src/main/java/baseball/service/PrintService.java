package baseball.service;

import baseball.domain.BaseBall;
import baseball.util.HintGenerator;

public class PrintService {

    public static String printResult(int[] answer, int[] input){
        BaseBall baseBall= HintGenerator.getHint(answer,input);
        int size=input.length;
        if(baseBall.checkNothing()){
            return "낫싱";
        }else{
            if(size==baseBall.getStrike()) {
                return size + "스트라이크\n" + size + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
            }else{
                return baseBall.getBall()+"볼 "+baseBall.getStrike()+"스트라이크";
            }
        }
    }
}
