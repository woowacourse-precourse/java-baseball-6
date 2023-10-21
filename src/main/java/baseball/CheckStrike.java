package baseball;

import java.util.List;

public class CheckStrike{
    Compare compare = new Compare();
    public String CheckStrikeCount(List<Integer> computer, List<Integer> player){
        // computer와 player의 배열을 입력받아 비교한다.
        // ball은 전체 equal 수에서 stirke를 빼면 ball의 수가 나온다.
        int equal = compare.CountEqualNumber(computer, player);
        int strike = compare.CountStrikeNumber(computer, player);
        int ball = equal - strike;

        if(equal == 0){
            // 같은게 없을 경우 낫싱을 출력
            return "낫싱";
        }
        else if(ball == 0){
            // 볼이 하나도 없을 경우 스트라이크만 출력
            return strike + "스트라이크";
        }
        else if(strike == 0){
            // 스트라이크가 없을 경우 볼만 출력
            return ball + "볼";
        }
        // 같은 것이 존재하고 ball과 strike의 값이 존재 할 경우 볼과 스트라이크를 모두 출력한다.
        return ball + "볼 " + strike + "스트라이크";
    }
}
