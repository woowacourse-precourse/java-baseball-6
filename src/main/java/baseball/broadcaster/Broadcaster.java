package baseball.broadcaster;

import java.util.List;

public class Broadcaster {
    public static RESULT broadcast(List<Integer> count){
        Integer strike = count.get(0);
        Integer ball = count.get(1);
        if((strike > 0) && (ball > 0)){
            System.out.printf("%d스트라이크 %d볼%n",strike,ball);
        } else if((strike == 0) && (ball > 0)){
            System.out.printf("%d볼%n",ball);
        } else if((strike > 0) && (ball == 0)){
            System.out.printf("%d스트라이크%n",strike);
        } else {
            System.out.println("낫싱");
        }
        if(strike==3){
            return RESULT.WIN;
        }else {
            return RESULT.LOSE;
        }
    }
}
