package baseball;

import java.util.List;

public class Counter {

    private int count;
    private int countStrike;
    private int countBall;

    private Counter() {}

    private void plusCount(){
        count++;
    }

    private void plusBall(){
        countBall++;
    }

    private void plusStrike(){
        countStrike++;
    }

    public boolean matchAny() {
        return count > 0;
    }

    public boolean isNothing(){
        return count == 0;
    }

    public boolean isOnlyBall(){
        return countBall > 0 && countStrike == 0;
    }

    public boolean isOnlyStrike(){
        return countStrike > 0 && countBall == 0;
    }

    public boolean isBallAndStrike() {
        return countBall > 0 && countStrike > 0;
    }

    public static Counter of(String[] arr, List<Integer> computer){
        Counter counter = new Counter();
        for (int i = 0; i < arr.length; i++) {
            count(arr, computer, i, counter);
        }
        return counter;
    }

    private static void count(String[] arr, List<Integer> computer, int i, Counter counter) {
        for (int j = 0; j < computer.size(); j++) {
            if (countCommand(arr, computer, i, counter, j)) break;
        }
    }

    private static boolean countCommand(String[] arr, List<Integer> computer, int i, Counter counter, int j) {
        if (arr[i].contains(String.valueOf(computer.get(j)))) {
            counter.plusCount();
            if (i == j) {
                counter.plusStrike();
                return true;
            } else {
                counter.plusBall();
                return true;
            }
        }
        return false;
    }

    public int getcountStrike() {
        return countStrike;
    }

    public int getcountBall() {
        return countBall;
    }
}
