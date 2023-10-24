package baseball;

import java.util.List;

public class Counter {

    private int count;
    private int countS;
    private int countB;

    private Counter() {}

    private void plusCount(){
        count++;
    }

    private void plusBall(){
        countB++;
    }

    private void plusStrike(){
        countS++;
    }

    public boolean matchAny() {
        return count > 0;
    }

    public boolean isNothing(){
        return count == 0;
    }

    public boolean isOnlyBall(){
        return countB > 0 && countS == 0;
    }

    public boolean isOnlyStrike(){
        return countS > 0 && countB == 0;
    }

    public boolean isBallAndStrike() {
        return countB > 0 && countS > 0;
    }

    public static Counter of(String[] arr, List<Integer> computer){
        Counter counter = new Counter();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < computer.size(); j++) {
                if (arr[i].contains(String.valueOf(computer.get(j)))) {
                    counter.plusCount();
                    if (i == j) {
                        counter.plusStrike();
                        break;
                    } else {
                        counter.plusBall();
                        break;
                    }
                }
            }
        }
        return counter;
    }

    public int getCountS() {
        return countS;
    }

    public int getCountB() {
        return countB;
    }
}
