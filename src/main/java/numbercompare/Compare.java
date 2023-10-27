package numbercompare;


import java.util.ArrayList;
import java.util.List;

public class Compare {
    private int ball;
    private int strike;

    public int[] CompareResult(List<Integer> li, List<Integer> computer) {
        ball = 0;
        strike = 0;

        int [] result = new int [2];
        List<Integer> li2 = new ArrayList<>(li);
        List<Integer> computer2 = new ArrayList<>(computer);

        ballCount(li2 , computer2);
        strikeCount(li, computer);
        strikeBallCal();

        result[0] = ball;
        result[1] = strike;


        return result;
    }

    public void ballCount(List<Integer> li2, List<Integer> computer2) {

        li2.retainAll(computer2);
        ball = li2.size();
    }


    public void strikeCount(List<Integer> li, List<Integer> compute) {
        for(int i =0; i < li.size(); i++) {
            if (li.get(i) == compute.get(i)) {
                strike++;
            }
        }
    }

    public void strikeBallCal(){
        ball = ball- strike;
    }
}


