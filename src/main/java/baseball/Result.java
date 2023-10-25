package baseball;

import java.util.List;

public class Result {

    Match match = new Match();
    public String result(List<Integer> answer, List<Integer> input){

        int matchball = match.matchcount(answer,input);         //몇개가 맞았는지
        int strike = match.strike(answer,input);                //strike의 개수
        int ball = matchball-strike;                            //맞은거 - strike = ball 계산

        if(matchball ==0)
            return "낫싱";
        else if (ball==0)
            return strike+"스트라이크";
        else if (strike==0)
            return ball + "볼";
        else
            return ball + "볼" +" "+ strike + "스트라이크";
    }

}
