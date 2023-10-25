package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> InputNumber = new ArrayList<>();
    int strike;
    int ball;

    public User(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    void clear() {
        InputNumber.clear();
        this.strike = 0;
        this.ball = 0;
    }

    void insertNum(int num){
        InputNumber.add(num);
    }

    public List<Integer> getList() {
        return InputNumber;
    }

    public String getResult() {
        String result = null;
        ball = getBall();
        strike = getStrike();

        if(ball == 0 && this.strike == 0) return "낫싱";
        if(this.ball != 0 ){
            result = ball + "볼";
        }

        if(strike != 0){
            if(ball == 0) result = strike + "스트라이크";
            else result = result + " " + strike + "스트라이크";
        }
        return result;
    }

    public boolean testDuplicate(char inputOneNum){
        int tester = Character.getNumericValue(inputOneNum);
        return !InputNumber.contains(tester);
    }
}