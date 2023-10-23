package baseball;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(3);
        answer.add(6);
        answer.add(9);
        ArrayList<Integer> trial = new ArrayList<>();
        trial.add(3);
        trial.add(6);
        trial.add(9);

        Umpire umpire = new Umpire();

        umpire.judge(answer,trial);
        System.out.println("Strike : "+umpire.getStrike() +", ball : " + umpire.getBall() + ", nothing : "+ umpire.isNothing());
    }
}
