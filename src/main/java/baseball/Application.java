package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computer = new Computer();
        List<Integer> answer = computer.createAnswer();

        ArrayList<Integer> trial = new ArrayList<>();
        trial.add(3);
        trial.add(6);
        trial.add(9);

        Umpire umpire = new Umpire();

        umpire.judge(answer,trial);
        System.out.println(answer);
        System.out.println("Strike : "+umpire.getStrike() +", ball : " + umpire.getBall() + ", nothing : "+ umpire.isNothing());
    }
}
