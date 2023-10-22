package baseball;

import java.util.List;

public class DisplayCount {
    public String displayCount(List<Integer> computer, List<Integer> player){
        Compare compare = new Compare();
        int total = compare.totalBall(computer, player);
        int strike = compare.countStrike(computer, player);
        int ball = total - strike;
        //볼만있는경우
//        if(ball > 0 && strike==0) System.out.println(ball+"볼");
//        //스트라이크만 있는경우
//        if(ball == 0 && strike>0) System.out.println(strike+"스트라이크");
//        //둘다있는경우
//        if(ball > 0 && strike > 0) System.out.println(ball+"볼 " + strike+"스트라이크");
//        if(ball == 0 && strike == 0) System.out.println("낫싱");
//        if(strike > 2){
//            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//        }
        if(total == 0){
            return "낫싱";
        }else if(strike == 0){
            return ball + "볼";
        }else if(ball == 0){
            return strike + "스트라이크";
        }
        return ball+"볼 " + strike+"스트라이크";
    }
}
