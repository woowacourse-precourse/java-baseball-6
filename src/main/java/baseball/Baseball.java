package baseball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Baseball {

    private int ball;
    private int strike;

    public void initBaseball(){
        this.strike = 0;
        this.ball = 0;
    }

    public boolean judgeBaseball(List<Integer> base, List<Integer> comp){

        for(int i = 0; i < comp.size(); i++){
            if (comp.get(i).equals(base.get(i))) {
                this.strike++;
            } else if (base.contains(comp.get(i))) {
                this.ball++;
            }
        }

        if(strike == 0 && ball == 0){
            System.out.println("낫싱");
            return false;
        }
        if(strike == 0){
            System.out.println(ball+"볼");
            return false;
        }
        if(ball == 0){
            System.out.println(strike+"스트라이크");
            return strike == 3;
        }
        System.out.println(ball+"볼 "+strike+"스트라이크");
        return false;
    }
}
