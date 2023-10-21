package baseball;

import java.util.List;

public class Compare {
    public int countStirke(List<Integer> com, List<Integer> user) {
        int strike = 0;
        for(int i = 0; i < com.size(); i++) {
            int userNum = user.get(i);
            if (com.get(i) == userNum) {
                strike++;
            }
        }
        return strike;
    }
    public int countAll(List<Integer> com, List<Integer> user) {
        int all = 0;
        for(int i = 0; i < com.size(); i++) {
            int userNum = user.get(i);
            if (com.contains(userNum)) {
                all++;
            }
        }
        return all;
    }
    public boolean isAnswer(int strike) {
        boolean Answer = false;
        if(strike == 3) {
            Answer = true;
        }
        return Answer;
    }
    public void startCompare() {
        int strike;
        int ball;

        boolean Answer = false;
        Result res = new Result();
        User use = new User();
        Computer compu = new Computer();
        List<Integer> comNum= compu.computerNumber();
        System.out.println(comNum.toString());
        while (!Answer) {
            List<Integer> userNum = use.userNumber();
            strike = countStirke(comNum, userNum);
            ball = countAll(comNum, userNum) - strike;
            res.printResult(strike, ball);
            Answer = isAnswer(strike);
        }
    }
}
